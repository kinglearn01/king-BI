export default [
  { name: '登录', path: '/user', layout: false, routes: [
    { path: '/user/login', component: './User/Login' },
      { path: '/user/register', component: './User/Register' },
    ] },
  { name: '欢迎页面', path: '/welcome', icon: 'smile', component: './Welcome' },
  { name: '添加图表', path: '/add_chart', icon: 'slackSquare', component: './AddChart' },
  { name: '添加图表(异步)', path: '/async_add_chart', icon: 'slackSquare', component: './AsyncAddChart' },
  { name: '我的图表', path: '/my_chart', icon: 'folder', component: './MyChart' },
  {
    path: '/admin',
    icon: 'crown',
    access: 'canAdmin',
    name: '管理员页面',
    routes: [
      { path: '/admin', redirect: '/admin/sub-page' },
      { path: '/admin/sub-page', component: './Admin' },
    ],
  },
  { path: '/', redirect: '/welcome' },
  { path: '*', layout: false, component: './404' },
];
