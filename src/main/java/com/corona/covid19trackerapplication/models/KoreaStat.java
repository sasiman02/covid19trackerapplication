package com.corona.covid19trackerapplication.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class KoreaStat {
    // 시도명
    private String country;
    // 전일대비확진환자증감
    private int diffFromPrevDay;
    // 확진환자수
    private int total;
    // 사망자수
    private int death;
    // 발병률
    private double incidence;
    // 일일 검사환자 수
    private int inspection;
}
