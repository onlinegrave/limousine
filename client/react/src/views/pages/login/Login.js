import React, { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { login } from './../../../api/app-client'
import {
  CAlert,
  CButton,
  CCard,
  CCardBody,
  CCardGroup,
  CCol,
  CContainer,
  CForm,
  CFormControl,
  CInputGroup,
  CInputGroupText,
  CRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

const Login = (props) => {
  const [companyId, setCompanyId] = useState('')
  const [userId, setUserId] = useState('')
  const [password, setPassword] = useState('')
  const history = useHistory()
  const [error, setError] = useState(false)
  const dispatch = useDispatch()

  const onCompanyIdChange = (event) => {
    setCompanyId(event.target.value)
  }

  const onPasswordChange = (event) => {
    setPassword(event.target.value)
  }

  const onUserIdChange = (event) => {
    setUserId(event.target.value)
  }

  const onSubmit = async (event) => {
    try {
      setError(false)
      event.preventDefault()
      const response = await login({ companyId, userId, password })
      console.log(response)
      if (!response.data || !response.data.token) {
        setError(true)
        return
      }

      localStorage.setItem('auth-token', response.data.token)
      dispatch({ type: 'set', user: { authToken: response.data.token } })
      history.replace('/users')
    } catch (e) {
      setError(true)
    }
  }

  return (
    <div className="bg-light min-vh-100 d-flex flex-row align-items-center">
      <CContainer>
        <CRow className="justify-content-center">
          {error ? <CAlert color="danger">Invalid credentials</CAlert> : null}
        </CRow>
        <CRow className="justify-content-center">
          <CCol md="8">
            <CCardGroup>
              <CCard className="p-4">
                <CCardBody>
                  <CForm>
                    <h1>Login</h1>
                    <p className="text-medium-emphasis">Sign In to your account</p>
                    <CInputGroup className="mb-3">
                      <CInputGroupText>
                        <CIcon name="cil-building" />
                      </CInputGroupText>
                      <CFormControl
                        placeholder="Company Id"
                        autoComplete="username"
                        required
                        value={companyId}
                        onChange={onCompanyIdChange}
                      />
                    </CInputGroup>
                    <CInputGroup className="mb-3">
                      <CInputGroupText>
                        <CIcon name="cil-user" />
                      </CInputGroupText>
                      <CFormControl
                        placeholder="User Id"
                        autoComplete="username"
                        required
                        value={userId}
                        onChange={onUserIdChange}
                      />
                    </CInputGroup>

                    <CInputGroup className="mb-4">
                      <CInputGroupText>
                        <CIcon name="cil-lock-locked" />
                      </CInputGroupText>
                      <CFormControl
                        id="password"
                        type="password"
                        placeholder="Password"
                        autoComplete="current-password"
                        value={password}
                        onChange={onPasswordChange}
                      />
                    </CInputGroup>
                    <CRow>
                      <CCol xs="6">
                        <CButton color="primary" className="px-4" onClick={onSubmit}>
                          Login
                        </CButton>
                      </CCol>
                      <CCol xs="6" className="text-right">
                        <Link to="/forgot-password">
                          <CButton color="link" className="px-0">
                            Forgot password?
                          </CButton>
                        </Link>
                      </CCol>
                    </CRow>
                  </CForm>
                </CCardBody>
              </CCard>
              <CCard className="text-white bg-primary py-5" style={{ width: '44%' }}>
                <CCardBody className="text-center">
                  <div>
                    <h2>Sign up</h2>
                    <p>Dont&apos;t have an account? Create one.</p>
                    <Link to="/register">
                      <CButton color="primary" className="mt-3" active tabIndex={-1}>
                        Register Now!
                      </CButton>
                    </Link>
                  </div>
                </CCardBody>
              </CCard>
            </CCardGroup>
          </CCol>
        </CRow>
      </CContainer>
    </div>
  )
}

export default Login
