/* Copyright 2026 上海如静知华信息科技有限公司 */
import {createRouter,createWebHistory} from 'vue-router';
import LoginView from '../views/LoginView.vue';
import AssetDashboard from '../views/admin/AssetDashboard.vue';
import AssetLedger from '../views/admin/AssetLedger.vue';
import WorkOrderCenter from '../views/admin/WorkOrderCenter.vue';
import MaintenanceCenter from '../views/admin/MaintenanceCenter.vue';
import TechnicianWorkbench from '../views/engineer/TechnicianWorkbench.vue';

export default createRouter({history:createWebHistory(),routes:[
 {path:'/',redirect:'/admin/dashboard'}, {path:'/login',component:LoginView},
 {path:'/admin/dashboard',component:AssetDashboard}, {path:'/admin/assets',component:AssetLedger},
 {path:'/admin/work-orders',component:WorkOrderCenter}, {path:'/admin/maintenance',component:MaintenanceCenter},
 {path:'/technician/workbench',component:TechnicianWorkbench},
 {path:'/admin/inspections',component:MaintenanceCenter}, {path:'/admin/spares',component:AssetLedger},
 {path:'/admin/analytics',component:AssetDashboard}, {path:'/admin/settings',component:AssetDashboard}
]})
