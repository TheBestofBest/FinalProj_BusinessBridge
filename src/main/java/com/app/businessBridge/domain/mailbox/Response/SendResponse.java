package com.app.businessBridge.domain.mailbox.Response;

import com.app.businessBridge.domain.mailbox.Entity.Mailbox;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SendResponse {
    private final Mailbox mailbox;
}
