<!-- Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ -->
<script setup>
const groups=[
 {label:'资产运营',items:[['/admin/dashboard','资产驾驶舱','⌂'],['/admin/assets','资产台账','▱'],['/admin/analytics','运行分析','⌁']]},
 {label:'维护执行',items:[['/admin/work-orders','维修工单','▤'],['/admin/maintenance','保养计划','◫'],['/admin/inspections','巡检记录','✓'],['/admin/spares','备件库存','⌘']]},
 {label:'系统治理',items:[['/admin/settings','基础配置','⚙'],['/technician/workbench','技师工作台','♙']]}
]
</script>
<template><div class="shell">
 <aside class="side"><div class="brand"><span>ZH</span><div><b>ZhuaTech EAM</b><small>ASSET OPERATIONS</small></div></div><button class="workspace-pick"><i></i><span><b>知华智造一号工厂</b><small>设备资产运营中心</small></span><em>⌄</em></button>
 <section v-for="group in groups" :key="group.label"><p>{{group.label}}</p><nav><RouterLink v-for="i in group.items" :key="i[1]" :to="i[0]"><i>{{i[2]}}</i><span>{{i[1]}}</span><b v-if="i[1]==='维修工单'">3</b></RouterLink></nav></section>
 <div class="side-foot"><span>许</span><div><b>许亦</b><small>资产平台主管</small></div><button>•••</button></div>
 </aside>
 <main class="main"><header class="top"><div><small>企业资产管理中心</small><b><slot name="title"/></b></div><label class="global-search">⌕ <input placeholder="搜索资产编码、位置、工单或备件"/><kbd>⌘ K</kbd></label><div class="top-actions"><button>?</button><button>♢<i></i></button><span>2026 / 07 / 31</span></div></header><div class="content"><slot/></div><footer>© 2026 上海如静知华信息科技有限公司 · <a href="https://www.zhuatech.cn/">知华科技</a></footer></main>
 </div></template>
