'use client'

import ECommerce from "@/components/Dashboard/E-commerce";
import DefaultLayout from "@/components/Layouts/DefaultLayout";


export default function Stats() {

    return (
        <>
        <DefaultLayout>
            통계 페이지
            <ECommerce></ECommerce>
        </DefaultLayout>
        </>
    )
}