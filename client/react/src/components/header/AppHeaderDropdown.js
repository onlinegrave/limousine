import React from 'react'
import { useDispatch } from 'react-redux'
import {
  CAvatar,
  CBadge,
  CDropdown,
  CDropdownDivider,
  CDropdownHeader,
  CDropdownItem,
  CDropdownMenu,
  CDropdownToggle,
  CForm,
  CButton,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

const AppHeaderDropdown = () => {
  const dispatch = useDispatch()
  return (
    <CDropdown variant="nav-item">
      <CDropdownToggle placement="bottom-end" className="py-0" caret={false}>
        <CAvatar src="avatars/8.jpg" size="md" />
      </CDropdownToggle>
      <CDropdownMenu className="pt-0" placement="bottom-end">
        <CDropdownHeader className="bg-light fw-semibold py-2">Account</CDropdownHeader>
        <CDropdownItem href="#/updates">
          <CIcon name="cil-bell" className="me-2" />
          Updates
          <CBadge color="info" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownItem href="#/messages">
          <CIcon name="cil-envelope-open" className="me-2" />
          Messages
          <CBadge color="success" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownItem href="#/tasks">
          <CIcon name="cil-task" className="me-2" />
          Tasks
          <CBadge color="danger" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownItem href="#/comments">
          <CIcon name="cil-comment-square" className="me-2" />
          Comments
          <CBadge color="warning" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownHeader className="bg-light fw-semibold py-2">Settings</CDropdownHeader>
        <CDropdownItem href="#/profile">
          <CIcon name="cil-user" className="me-2" />
          Profile
        </CDropdownItem>
        <CDropdownItem href="#/settings">
          <CIcon name="cil-settings" className="me-2" />
          Settings
        </CDropdownItem>
        <CDropdownItem href="#/payments">
          <CIcon name="cil-credit-card" className="me-2" />
          Payments
          <CBadge color="secondary" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownItem href="#/projects">
          <CIcon name="cil-file" className="me-2" />
          Projects
          <CBadge color="primary" className="ms-2">
            42
          </CBadge>
        </CDropdownItem>
        <CDropdownDivider />
        <CDropdownItem href="#">
          <CIcon name="cil-lock-locked" className="me-2" />
          Lock Account
        </CDropdownItem>
        <CDropdownItem>
          <CIcon name="cil-lock-locked" className="me-2" />
          <CButton
            color="primary"
            type="submit"
            onClick={() => {
              localStorage.removeItem('auth-token')
              dispatch({ type: 'set', user: null })
            }}
          >
            Log out
          </CButton>
        </CDropdownItem>
      </CDropdownMenu>
    </CDropdown>
  )
}

export default AppHeaderDropdown
