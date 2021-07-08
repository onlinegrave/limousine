import React from 'react'

// pages
const Login = React.lazy(() => import('./views/pages/login/Login'))
const ForgotPassword = React.lazy(() => import('./views/pages/forgot-password/ForgotPassword'))
const ResetPassword = React.lazy(() => import('./views/pages/reset-password/ResetPassword'))
const Register = React.lazy(() => import('./views/pages/register/Register'))
const Page500 = React.lazy(() => import('./views/pages/page500/Page500'))
const Page404 = React.lazy(() => import('./views/pages/page404/Page404'))
// examples

const Colors = React.lazy(() => import('./views/theme/colors/Colors'))
const Typography = React.lazy(() => import('./views/theme/typography/Typography'))

const Accordion = React.lazy(() => import('./views/components/base/accordion/Accordion'))
const Breadcrumbs = React.lazy(() => import('./views/components/base/breadcrumbs/Breadcrumbs'))
const Cards = React.lazy(() => import('./views/components/base/cards/Cards'))
const Carousels = React.lazy(() => import('./views/components/base/carousels/Carousels'))
const Collapses = React.lazy(() => import('./views/components/base/collapses/Collapses'))
const ListGroups = React.lazy(() => import('./views/components/base/list-groups/ListGroups'))
const Navs = React.lazy(() => import('./views/components/base/navs/Navs'))
const Paginations = React.lazy(() => import('./views/components/base/paginations/Paginations'))
const Popovers = React.lazy(() => import('./views/components/base/popovers/Popovers'))
const Progress = React.lazy(() => import('./views/components/base/progress/Progress'))
const Spinners = React.lazy(() => import('./views/components/base/spinners/Spinners'))
const Tables = React.lazy(() => import('./views/components/base/tables/Tables'))
const Tooltips = React.lazy(() => import('./views/components/base/tooltips/Tooltips'))

const Buttons = React.lazy(() => import('./views/components/buttons/buttons/Buttons'))
const ButtonGroups = React.lazy(() =>
  import('./views/components/buttons/button-groups/ButtonGroups'),
)
const Dropdowns = React.lazy(() => import('./views/components/buttons/dropdowns/Dropdowns'))

const ChecksRadios = React.lazy(() => import('./views/components/forms/checks-radios/ChecksRadios'))
const FloatingLabels = React.lazy(() =>
  import('./views/components/forms/floating-labels/FloatingLabels'),
)
const FormControl = React.lazy(() => import('./views/components/forms/form-control/FormControl'))
const InputGroup = React.lazy(() => import('./views/components/forms/input-group/InputGroup'))
const Layout = React.lazy(() => import('./views/components/forms/layout/Layout'))
const Range = React.lazy(() => import('./views/components/forms/range/Range'))
const Select = React.lazy(() => import('./views/components/forms/select/Select'))
const Validation = React.lazy(() => import('./views/components/forms/validation/Validation'))

const CoreUIIcons = React.lazy(() => import('./views/components/icons/coreui-icons/CoreUIIcons'))
const Flags = React.lazy(() => import('./views/components/icons/flags/Flags'))
const Brands = React.lazy(() => import('./views/components/icons/brands/Brands'))

const Alerts = React.lazy(() => import('./views/components/notifications/alerts/Alerts'))
const Badges = React.lazy(() => import('./views/components/notifications/badges/Badges'))
const Modals = React.lazy(() => import('./views/components/notifications/modals/Modals'))
const Toasts = React.lazy(() => import('./views/components/notifications/toasts/Toasts'))

// const Login = React.lazy(() => import('./views/examples/pages/login/Login'))
// const Register = React.lazy(() => import('./views/examples/pages/register/Register'))
// const Page404 = React.lazy(() => import('./views/examples/pages/page404/Page404'))
// const Page500 = React.lazy(() => import('./views/examples/pages/page500/Page500'))

const Widgets = React.lazy(() => import('./views/components/widgets/Widgets'))

const Charts = React.lazy(() => import('./views/components/charts/Charts'))
const Dashboard = React.lazy(() => import('./views/dashboard/Dashboard'))

const OrderAll = React.lazy(() => import('./views/orders/Index'))
const OrderNew = React.lazy(() => import('./views/orders/New'))
const OrderEdit = React.lazy(() => import('./views/orders/Edit'))
const OrderShow = React.lazy(() => import('./views/orders/Show'))

const OrderHistoryAll = React.lazy(() => import('./views/order-histories/Index'))
const OrderHistoryNew = React.lazy(() => import('./views/order-histories/New'))
const OrderHistoryEdit = React.lazy(() => import('./views/order-histories/Edit'))
const OrderHistoryShow = React.lazy(() => import('./views/order-histories/Show'))

const Map = React.lazy(() => import('./views/map/Map'))

const MessengerAll = React.lazy(() => import('./views/messengers/Index'))
const MessengerNew = React.lazy(() => import('./views/messengers/New'))
const MessengerEdit = React.lazy(() => import('./views/messengers/Edit'))
const MessengerShow = React.lazy(() => import('./views/messengers/Show'))

const CompanyAll = React.lazy(() => import('./views/companies/Index'))
const CompanyNew = React.lazy(() => import('./views/companies/New'))
const CompanyEdit = React.lazy(() => import('./views/companies/Edit'))
const CompanyShow = React.lazy(() => import('./views/companies/Show'))

const UserAll = React.lazy(() => import('./views/users/Index'))
const UserNew = React.lazy(() => import('./views/users/New'))
const UserEdit = React.lazy(() => import('./views/users/Edit'))
const UserShow = React.lazy(() => import('./views/users/Show'))

const UserGroupAll = React.lazy(() => import('./views/user-groups/Index'))
const UserGroupNew = React.lazy(() => import('./views/user-groups/New'))
const UserGroupEdit = React.lazy(() => import('./views/user-groups/Edit'))
const UserGroupShow = React.lazy(() => import('./views/user-groups/Show'))

const VehicleAll = React.lazy(() => import('./views/vehicles/Index'))
const VehicleNew = React.lazy(() => import('./views/vehicles/New'))
const VehicleEdit = React.lazy(() => import('./views/vehicles/Edit'))
const VehicleShow = React.lazy(() => import('./views/vehicles/Show'))

const CustomerAll = React.lazy(() => import('./views/customers/Index'))
const CustomerNew = React.lazy(() => import('./views/customers/New'))
const CustomerEdit = React.lazy(() => import('./views/customers/Edit'))
const CustomerShow = React.lazy(() => import('./views/customers/Show'))

const OrderImportAll = React.lazy(() => import('./views/order-imports/Index'))
const OrderImportNew = React.lazy(() => import('./views/order-imports/New'))
const OrderImportEdit = React.lazy(() => import('./views/order-imports/Edit'))
const OrderImportShow = React.lazy(() => import('./views/order-imports/Show'))

const HotelOrderImportAll = React.lazy(() => import('./views/hotel-order-imports/Index'))
const HotelOrderImportNew = React.lazy(() => import('./views/hotel-order-imports/New'))
const HotelOrderImportEdit = React.lazy(() => import('./views/hotel-order-imports/Edit'))
const HotelOrderImportShow = React.lazy(() => import('./views/hotel-order-imports/Show'))

const OptionSettingAll = React.lazy(() => import('./views/option-settings/Index'))
const OptionSettingNew = React.lazy(() => import('./views/option-settings/New'))
const OptionSettingEdit = React.lazy(() => import('./views/option-settings/Edit'))
const OptionSettingShow = React.lazy(() => import('./views/option-settings/Show'))

const Updates = React.lazy(() => import('./views/updates/Updates'))
const Messages = React.lazy(() => import('./views/messages/Messages'))
const Tasks = React.lazy(() => import('./views/tasks/Tasks'))
const Comments = React.lazy(() => import('./views/comments/Comments'))
const Profile = React.lazy(() => import('./views/profile/Profile'))
const Settings = React.lazy(() => import('./views/settings/Settings'))
const Payments = React.lazy(() => import('./views/payments/Payments'))
const Projects = React.lazy(() => import('./views/projects/Projects'))

const routes = [
  { path: '/', exact: true, name: 'Home' },
  { path: '/dashboard', name: 'Dashboard', component: Dashboard },
  // { path: '/profile', name: 'Profile', component: Profile },
  { path: '/settings', name: 'Settings', component: Settings },
  // { path: '/notifications', name: 'Notifications', component: Notifications },

  { path: '/orders', name: 'Orders', component: OrderAll },
  { path: '/orders/new', name: 'New order', component: OrderNew },
  { path: '/orders/:id', name: 'Show order', component: OrderShow },
  { path: '/orders/:id/edit', name: 'Edit order', component: OrderEdit },

  { path: '/order-histories', name: 'Order Histories', component: OrderHistoryAll },
  { path: '/order-histories/new', name: 'Order Histories', component: OrderHistoryNew },
  { path: '/order-histories/:id', name: 'Order Histories', component: OrderHistoryShow },
  { path: '/order-histories/:id/edit', name: 'Order Histories', component: OrderHistoryEdit },

  { path: '/map', name: 'Dashboard', component: Map },
  { path: '/messengers', name: 'Messengers', component: MessengerAll },
  { path: '/messengers/new', name: 'New messenger', component: MessengerNew },
  { path: '/messengers/:id', name: 'Show messenger', component: MessengerShow },
  { path: '/messengers/:id/edit', name: 'Edit messenger', component: MessengerEdit },

  { path: '/companies', name: 'Companies', component: CompanyAll },
  { path: '/companies/new', name: 'New company', component: CompanyNew },
  { path: '/companies/:id', name: 'Show company', component: CompanyShow },
  { path: '/companies/:id/edit', name: 'Edit company', component: CompanyEdit },

  { path: '/users', name: 'User', component: UserAll },
  { path: '/users/new', name: 'New user', component: UserNew },
  { path: '/users/:id', name: 'Show user', component: UserShow },
  { path: '/users/:id/edit', name: 'Edit user', component: UserEdit },

  { path: '/user-groups', name: 'User groups', component: UserGroupAll },
  { path: '/user-groups/new', name: 'New user group', component: UserGroupNew },
  { path: '/user-groups/:id', name: 'Show user group', component: UserGroupShow },
  { path: '/user-groups/:id/edit', name: 'Edit user group', component: UserGroupEdit },

  { path: '/vehicles', name: 'Vehicles', component: VehicleAll },
  { path: '/vehicles/new', name: 'New vehicle', component: VehicleNew },
  { path: '/vehicles/:id', name: 'Show vehicle', component: VehicleShow },
  { path: '/vehicles/:id/edit', name: 'Edit vehicle', component: VehicleEdit },

  { path: '/customers', name: 'Customers', component: CustomerAll },
  { path: '/customers/new', name: 'New customer', component: CustomerNew },
  { path: '/customers/:id', name: 'Show customer', component: CustomerShow },
  { path: '/customers/:id/edit', name: 'Edit customer', component: CustomerEdit },

  { path: '/order-imports', name: 'Order imports', component: OrderImportAll },
  { path: '/order-imports/new', name: 'New order import', component: OrderImportNew },
  { path: '/order-imports/:id', name: 'Show order import', component: OrderImportShow },
  { path: '/order-imports/:id/edit', name: 'Edit order import', component: OrderImportEdit },

  { path: '/hotel-order-imports', name: 'Hotel order imports', component: HotelOrderImportAll },
  {
    path: '/hotel-order-imports/new',
    name: 'New hotel order import',
    component: HotelOrderImportNew,
  },
  {
    path: '/hotel-order-imports/:id',
    name: 'Show hotel order import',
    component: HotelOrderImportShow,
  },
  {
    path: '/hotel-order-imports/:id/edit',
    name: 'Edit hotel order import',
    component: HotelOrderImportEdit,
  },

  { path: '/option-settings', name: 'Options settings', component: OptionSettingAll },
  { path: '/option-settings/new', name: 'New option settings', component: OptionSettingNew },
  { path: '/option-settings/:id', name: 'Show option settings', component: OptionSettingShow },
  { path: '/option-settings/:id/edit', name: 'Edit option settings', component: OptionSettingEdit },

  { path: '/updates', name: 'Updates', component: Updates },
  { path: '/messages', name: 'Messages', component: Messages },
  { path: '/tasks', name: 'Tasks', component: Tasks },
  { path: '/comments', name: 'Comments', component: Comments },
  { path: '/profile', name: 'Profile', component: Profile },
  { path: '/settings', name: 'Settings', component: Settings },
  { path: '/payments', name: 'Payments', component: Payments },
  { path: '/projects', name: 'Projects', component: Projects },

  { path: '/theme', name: 'Theme', component: Colors, exact: true },
  { path: '/theme/colors', name: 'Colors', component: Colors },
  { path: '/theme/typography', name: 'Typography', component: Typography },
  { path: '/base', name: 'Base', component: Cards, exact: true },
  { path: '/base/accordion', name: 'Accordion', component: Accordion },
  { path: '/base/breadcrumbs', name: 'Breadcrumbs', component: Breadcrumbs },
  { path: '/base/cards', name: 'Cards', component: Cards },
  { path: '/base/carousels', name: 'Carousel', component: Carousels },
  { path: '/base/collapses', name: 'Collapse', component: Collapses },
  { path: '/base/list-groups', name: 'List Groups', component: ListGroups },
  { path: '/base/navs', name: 'Navs', component: Navs },
  { path: '/base/paginations', name: 'Paginations', component: Paginations },
  { path: '/base/popovers', name: 'Popovers', component: Popovers },
  { path: '/base/progress', name: 'Progress', component: Progress },
  { path: '/base/spinners', name: 'Spinners', component: Spinners },
  { path: '/base/tables', name: 'Tables', component: Tables },
  { path: '/base/tooltips', name: 'Tooltips', component: Tooltips },
  { path: '/buttons', name: 'Buttons', component: Buttons, exact: true },
  { path: '/buttons/buttons', name: 'Buttons', component: Buttons },
  { path: '/buttons/dropdowns', name: 'Dropdowns', component: Dropdowns },
  { path: '/buttons/button-groups', name: 'Button Groups', component: ButtonGroups },
  { path: '/charts', name: 'Charts', component: Charts },
  { path: '/forms', name: 'Forms', component: FormControl, exact: true },
  { path: '/forms/form-control', name: 'Form Control', component: FormControl },
  { path: '/forms/select', name: 'Select', component: Select },
  { path: '/forms/checks-radios', name: 'Checks & Radios', component: ChecksRadios },
  { path: '/forms/range', name: 'Range', component: Range },
  { path: '/forms/input-group', name: 'Input Group', component: InputGroup },
  { path: '/forms/floating-labels', name: 'Floating Labels', component: FloatingLabels },
  { path: '/forms/layout', name: 'Layout', component: Layout },
  { path: '/forms/validation', name: 'Validation', component: Validation },
  { path: '/icons', exact: true, name: 'Icons', component: CoreUIIcons },
  { path: '/icons/coreui-icons', name: 'CoreUI Icons', component: CoreUIIcons },
  { path: '/icons/flags', name: 'Flags', component: Flags },
  { path: '/icons/brands', name: 'Brands', component: Brands },
  { path: '/notifications', name: 'Notifications', component: Alerts, exact: true },
  { path: '/notifications/alerts', name: 'Alerts', component: Alerts },
  { path: '/notifications/badges', name: 'Badges', component: Badges },
  { path: '/notifications/modals', name: 'Modals', component: Modals },
  { path: '/notifications/toasts', name: 'Toasts', component: Toasts },
  { path: '/login', name: 'Login', component: Login },
  { path: '/register', name: 'Register', component: Register },
  { path: '/forgot-password', name: 'Register', component: ForgotPassword },
  { path: '/reset-password', name: 'Register', component: ResetPassword },
  { path: '/404', name: '404', component: Page404 },
  { path: '/500', name: '500', component: Page500 },
  { path: '/widgets', name: 'Widgets', component: Widgets },
]

export default routes
