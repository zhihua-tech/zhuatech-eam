/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetHealthService {
    public Result assess(Request request) {
        int score = Math.min(100, (int) Math.round(Math.min(20, request.temperatureDelta() * 2)
            + request.vibrationScore() * .35 + Math.min(30, request.failureCount90d() * 10)
            + Math.min(20, request.daysSinceInspection() / 2.0) + request.criticality() * .2));
        String level = score >= 75 ? "CRITICAL" : score >= 50 ? "HIGH" : score >= 25 ? "WATCH" : "HEALTHY";
        List<String> actions = new ArrayList<>();
        if (request.vibrationScore() >= 70) actions.add("安排振动复测与轴承检查");
        if (request.failureCount90d() > 0) actions.add("复盘近九十天故障模式与根因");
        if (request.daysSinceInspection() >= 30) actions.add("补充逾期点检并更新设备履历");
        if (actions.isEmpty()) actions.add("保持预防性维护周期");
        return new Result(request.assetCode(), score, level, score >= 50, actions);
    }

    public record Request(@NotBlank String assetCode, @Min(0) double temperatureDelta,
                          @Min(0) @Max(100) int vibrationScore, @Min(0) int failureCount90d,
                          @Min(0) int daysSinceInspection, @Min(0) @Max(100) int criticality) {}
    public record Result(String assetCode, int riskScore, String level,
                         boolean workOrderRequired, List<String> actions) {}
}
