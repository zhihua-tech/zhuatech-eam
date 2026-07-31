/* Copyright 2026 上海如静知华信息科技有限公司 */
export const assets=[
 {code:'AST-CNC-018',name:'五轴加工中心',category:'生产设备',location:'一号工厂 · 精加工区',custodian:'许亦',health:'健康',status:'运行中',utilization:87,value:'286.0 万'},
 {code:'AST-AHU-006',name:'组合式空调机组',category:'动力设备',location:'一号工厂 · 屋顶机房',custodian:'陈序',health:'需关注',status:'运行中',utilization:93,value:'48.0 万'},
 {code:'AST-CMP-012',name:'变频螺杆空压机',category:'动力设备',location:'公用工程站',custodian:'梁川',health:'健康',status:'运行中',utilization:78,value:'63.5 万'},
 {code:'AST-AGV-027',name:'潜伏式搬运机器人',category:'物流设备',location:'成品仓 · A 区',custodian:'周岚',health:'需关注',status:'停机检修',utilization:64,value:'16.8 万'}
]
export const workOrders=[
 {no:'WO-20260731-014',asset:'AST-AGV-027',title:'驱动轮异响并伴随定位偏差',type:'故障维修',priority:'特急',assignee:'宋启',due:'今天 14:30',status:'处理中'},
 {no:'WO-20260731-009',asset:'AST-AHU-006',title:'送风压差持续高于预警线',type:'状态维修',priority:'紧急',assignee:'陈序',due:'今天 18:00',status:'待接单'},
 {no:'WO-20260730-026',asset:'AST-CNC-018',title:'主轴振动趋势复核与润滑检查',type:'预防保养',priority:'一般',assignee:'许亦',due:'08-02 10:00',status:'待验收'},
 {no:'WO-20260729-018',asset:'AST-CMP-012',title:'更换油分芯并复位保养计时',type:'计划保养',priority:'一般',assignee:'梁川',due:'昨天 16:20',status:'已完成'}
]
export const plans=[
 {no:'MP-CNC-018-M',asset:'AST-CNC-018',name:'加工中心月度点检',cycle:'每 30 天',next:'08-02',team:'精密维修组',progress:72,status:'待执行'},
 {no:'MP-AHU-006-Q',asset:'AST-AHU-006',name:'空调机组季度保养',cycle:'每 90 天',next:'08-05',team:'公用工程组',progress:36,status:'待准备'},
 {no:'MP-CMP-012-M',asset:'AST-CMP-012',name:'空压机运行保养',cycle:'每 45 天',next:'08-09',team:'动力维修组',progress:18,status:'计划中'}
]
export const inspections=[
 {no:'IR-20260731-031',asset:'AST-AGV-027',inspector:'周岚',time:'09:18',result:'异常',finding:'右侧驱动轮温升 18℃'},
 {no:'IR-20260731-025',asset:'AST-CNC-018',inspector:'许亦',time:'07:42',result:'正常',finding:'主轴、刀库与冷却系统正常'},
 {no:'IR-20260730-086',asset:'AST-AHU-006',inspector:'陈序',time:'昨天 16:05',result:'异常',finding:'初效段压差 182Pa'},
 {no:'IR-20260730-071',asset:'AST-CMP-012',inspector:'梁川',time:'昨天 14:36',result:'正常',finding:'排气温度与电流正常'}
]
export const spareParts=[
 {code:'SP-BRG-6208',name:'主轴精密轴承',spec:'6208/P4',stock:3,safety:4,unit:'套',warehouse:'设备备件库'},
 {code:'SP-FLT-AHU6',name:'初效过滤器',spec:'G4 595×595',stock:18,safety:12,unit:'片',warehouse:'公用工程库'},
 {code:'SP-OIL-CMP46',name:'空压机润滑油',spec:'ISO VG46 / 20L',stock:5,safety:3,unit:'桶',warehouse:'设备备件库'},
 {code:'SP-WHL-AGV27',name:'AGV 驱动轮',spec:'PU 180mm',stock:1,safety:2,unit:'件',warehouse:'物流备件库'}
]
