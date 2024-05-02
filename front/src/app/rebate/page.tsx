'use client'

import DefaultLayout from "@/components/Layouts/DefaultLayout";
import MemberTable from "./MemberTable";


export default function Rebate() {

    return (
        <>
        <DefaultLayout>
            정산 페이지
            <MemberTable></MemberTable>
        </DefaultLayout>
        </>
    )
}