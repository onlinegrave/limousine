import React from 'react'
import { NavLink } from 'react-router-dom'
import { useSelector, useDispatch } from 'react-redux'
import {
  CContainer,
  CHeader,
  CHeaderBrand,
  CHeaderDivider,
  CHeaderNav,
  CHeaderToggler,
  CNavLink,
  CNavItem,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

import { AppBreadcrumb } from './index'

import { AppHeaderDropdown } from './header/index'

const AppHeader = () => {
  const dispatch = useDispatch()
  const sidebarShow = useSelector((state) => state.sidebarShow)

  return (
    <CHeader position="sticky" className="mb-4">
      <CContainer fluid>
        <CHeaderToggler
          className="ms-md-3 d-lg-none"
          onClick={() => dispatch({ type: 'set', sidebarShow: !sidebarShow })}
        >
          <CIcon name="cil-menu" size="lg" />
        </CHeaderToggler>
        <CHeaderBrand className="mx-auto d-md-none" to="/">
          <CIcon name="logo" height="48" alt="Logo" />
        </CHeaderBrand>
        <CHeaderNav className="d-none d-md-flex me-auto">
          {/* <CNavItem>
            <CNavLink to="/dashboard" component={NavLink} activeClassName="active">
              Dashboard
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/orders" component={NavLink} activeClassName="active">
              Orders
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/order-histories" component={NavLink} activeClassName="active">
              Order Histories
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/map" component={NavLink} activeClassName="active">
              Map
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/messengers" component={NavLink} activeClassName="active">
              Messengers
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/companies" component={NavLink} activeClassName="active">
              Companies
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/users" component={NavLink} activeClassName="active">
              Users
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/user-groups" component={NavLink} activeClassName="active">
              User Groups
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/vehicles" component={NavLink} activeClassName="active">
              Vehicles
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/customers" component={NavLink} activeClassName="active">
              Customers
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/order-imports" component={NavLink} activeClassName="active">
              Order imports
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/hotel-order-imports" component={NavLink} activeClassName="active">
              Hotel Order Imports
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink to="/option-settings" component={NavLink} activeClassName="active">
              Option Settings
            </CNavLink>
          </CNavItem> */}
        </CHeaderNav>
        <CHeaderNav>
          <CNavItem>
            <CNavLink href="#">
              <CIcon name="cil-bell" size="lg" />
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="#">
              <CIcon name="cil-list" size="lg" />
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="#">
              <CIcon name="cil-envelope-open" size="lg" />
            </CNavLink>
          </CNavItem>
        </CHeaderNav>
        <CHeaderNav className="ms-3">
          <AppHeaderDropdown />
        </CHeaderNav>
      </CContainer>
      <CHeaderDivider />
      <CContainer fluid>
        <AppBreadcrumb />
      </CContainer>
    </CHeader>
  )
}

export default AppHeader
