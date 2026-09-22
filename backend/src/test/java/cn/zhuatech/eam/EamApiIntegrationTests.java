/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam;
import org.junit.jupiter.api.Test; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc; import org.springframework.boot.test.context.SpringBootTest; import org.springframework.http.MediaType; import org.springframework.test.web.servlet.MockMvc; import java.time.LocalDateTime; import java.util.regex.*; import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@SpringBootTest @AutoConfigureMockMvc class EamApiIntegrationTests {
    @Autowired MockMvc mvc;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    private String login() throws Exception {String json=mvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON).content("{\"username\":\"admin\",\"password\":\"admin123\"}")).andExpect(status().isOk()).andExpect(jsonPath("$.data.user.role").value("ADMIN")).andReturn().getResponse().getContentAsString();Matcher m=Pattern.compile("\\\"token\\\":\\\"([^\\\"]+)\\\"").matcher(json);if(!m.find())throw new AssertionError("登录响应中缺少 token");return m.group(1);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void adminCanReadDashboardAndAssets() throws Exception {String token=login();mvc.perform(get("/api/eam/dashboard").header("Authorization","Bearer "+token)).andExpect(status().isOk()).andExpect(jsonPath("$.data.assetCount").value(4)).andExpect(jsonPath("$.data.openOrders").value(3));mvc.perform(get("/api/eam/assets").header("Authorization","Bearer "+token)).andExpect(status().isOk()).andExpect(jsonPath("$.data.length()").value(4));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void assetManagerCanCreateWorkOrder() throws Exception {String due=LocalDateTime.now().plusDays(2).withNano(0).toString();String body="{\"assetCode\":\"AST-CNC-018\",\"title\":\"测试维修工单\",\"orderType\":\"故障维修\",\"priority\":\"一般\",\"assignee\":\"测试员\",\"dueAt\":\""+due+"\"}";mvc.perform(post("/api/eam/work-orders").header("Authorization","Bearer "+login()).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk()).andExpect(jsonPath("$.data.status").value("待接单"));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void adminCanAssessCriticalAssetHealth() throws Exception {mvc.perform(post("/api/eam/asset-health").header("Authorization","Bearer "+login()).contentType(MediaType.APPLICATION_JSON).content("{\"assetCode\":\"AST-CNC-018\",\"temperatureDelta\":8,\"vibrationScore\":80,\"failureCount90d\":2,\"daysSinceInspection\":45,\"criticality\":90}")).andExpect(status().isOk()).andExpect(jsonPath("$.data.riskScore").value(100)).andExpect(jsonPath("$.data.level").value("CRITICAL")).andExpect(jsonPath("$.data.workOrderRequired").value(true));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void anonymousRequestIsDenied() throws Exception {mvc.perform(get("/api/eam/assets")).andExpect(status().isUnauthorized());}
}
