import React from 'react'
import {
  CButton,
  CCard,
  CCardBody,
  CCol,
  CContainer,
  CForm,
  CFormControl,
  CInputGroup,
  CInputGroupText,
  CRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

const ForgotPassword = () => {
  return (
    <div className="bg-light min-vh-100 d-flex flex-row align-items-center">
      <CContainer>
        <CRow className="justify-content-center">
          <CCol md="9" lg="7" xl="6">
            <CCard className="mx-4">
              <CCardBody className="p-4">
                <CForm>
                  <h1>Forgot password?</h1>
                  <p className="text-medium-emphasis">
                    Enter your credentials and we will help you reset your password.
                  </p>
                  <CInputGroup className="mb-3">
                    <CInputGroupText>
                      <CIcon name="cil-building" />
                    </CInputGroupText>
                    <CFormControl placeholder="Company Id" autoComplete="username" />
                  </CInputGroup>
                  <CInputGroup className="mb-3">
                    <CInputGroupText>
                      <CIcon name="cil-user" />
                    </CInputGroupText>
                    <CFormControl placeholder="User Id" autoComplete="username" />
                  </CInputGroup>

                  <CButton color="success" block>
                    Send reset email
                  </CButton>
                </CForm>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      </CContainer>
    </div>
  )
}

export default ForgotPassword
