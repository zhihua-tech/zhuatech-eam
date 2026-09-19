/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class CriticalWorkPermitGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.lockoutTagoutComplete()) blockers.add("上锁挂牌程序未完成");
        if (!request.energyIsolationVerified()) blockers.add("能源隔离尚未独立验证");
        if (!request.technicianQualified()) blockers.add("作业人员资质或培训无效");
        if (!request.approvedWorkInstruction()) blockers.add("未使用批准版本的作业指导书");
        if (request.criticalAsset() && !request.safetyPermitApproved()) blockers.add("关键设备安全作业许可未批准");
        if (!request.sparePartsReady()) actions.add("确认关键备件与专用工具到位");
        if (!request.shutdownWindowApproved()) actions.add("取得停机窗口和生产协调批准");
        if (request.emergencyWork()) actions.add("启动紧急作业升级、监护和事后复盘");

        Decision decision = !blockers.isEmpty() ? Decision.HOLD
                : !actions.isEmpty() ? Decision.APPROVAL_REQUIRED : Decision.RELEASE;
        return new Assessment(request.workOrderNo(), decision,
                List.copyOf(blockers), List.copyOf(actions));
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String workOrderNo, boolean criticalAsset,
                          boolean lockoutTagoutComplete, boolean energyIsolationVerified,
                          boolean technicianQualified, boolean approvedWorkInstruction,
                          boolean safetyPermitApproved, boolean sparePartsReady,
                          boolean shutdownWindowApproved, boolean emergencyWork) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(String workOrderNo, Decision decision, List<String> blockers,
                             List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { RELEASE, APPROVAL_REQUIRED, HOLD }
}
