package com.app.businessBridge.domain.confirmFormType.dto;

import com.app.businessBridge.domain.confirmFormType.entity.ConfirmFormType;
import com.app.businessBridge.domain.confirmStatus.entity.ConfirmStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ConfrimFormTypeDTO {
    private Long id;
    private String formName;
    private String formDescription;

    public ConfrimFormTypeDTO(ConfirmFormType confirmFormType) {
        this.id = confirmFormType.getId();
        this.formName = confirmFormType.getFormName();
        this.formDescription = confirmFormType.getFormDescription();

    }
}
