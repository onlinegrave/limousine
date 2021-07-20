import React, { useState, useEffect } from 'react'
import {
  CTable,
  CTableHead,
  CTableRow,
  CTableBody,
  CTableHeaderCell,
  CTableDataCell,
  CCard,
  CCardBody,
  CPagination,
  CPaginationItem,
} from '@coreui/react'
import { fetchOneUser } from '../../api/app-client'

const New = () => {
  const [error, setError] = useState(false)
  const [data, setData] = useState([])
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    fetchData()
    return () => {
      console.log('CLEANING')
    }
  }, [])

  const fetchData = async () => {
    try {
      setLoading(true)
      const response = await fetchOneUser()
      console.log(response)
      if (response.data) {
        setData(response.data)
      }
    } catch (e) {
      console.log(e)
    } finally {
      setLoading(false)
    }
  }

  const renderLoading = () => {
    return (
      <div className="pt-3 text-center">
        <div className="sk-spinner sk-spinner-pulse"></div>
      </div>
    )
  }

  const renderEmpty = () => {
    return (
      <div className="card">
        <div className="card-body">No data</div>
      </div>
    )
  }

  const renderError = () => {
    return (
      <div className="card">
        <div className="card-body">Something went wrong</div>
      </div>
    )
  }

  const onClickNext = (e) => {
    e.preventDefault()
  }

  const onClickPrevious = (e) => {}

  const onClickNumber = (e) => {}

  const renderData = () => {
    return (
      <CCard>
        <CCardBody>
          <CTable hover>
            <CTableHead>
              <CTableRow>
                {/* <CTableHeaderCell scope="col">#</CTableHeaderCell> */}
                <CTableHeaderCell scope="col">Company Id</CTableHeaderCell>
                <CTableHeaderCell scope="col">User Id</CTableHeaderCell>
                <CTableHeaderCell scope="col">Username</CTableHeaderCell>
                {/* <CTableHeaderCell scope="col">Password</CTableHeaderCell> */}
                {/* <CTableHeaderCell scope="col">Expire Date</CTableHeaderCell> */}
                <CTableHeaderCell scope="col">Group Id</CTableHeaderCell>
                <CTableHeaderCell scope="col">Department</CTableHeaderCell>
                <CTableHeaderCell scope="col">Tel1</CTableHeaderCell>
                {/* <CTableHeaderCell scope="col">User Tel 2</CTableHeaderCell> */}
                <CTableHeaderCell scope="col">Email</CTableHeaderCell>
                <CTableHeaderCell scope="col">Language</CTableHeaderCell>
                <CTableHeaderCell scope="col">Flight Refresh Interval</CTableHeaderCell>
                <CTableHeaderCell scope="col">Remarks</CTableHeaderCell>
                <CTableHeaderCell scope="col">Status</CTableHeaderCell>
                {/* <CTableHeaderCell scope="col">Updated By</CTableHeaderCell> */}
                {/* <CTableHeaderCell scope="col">Updated Date</CTableHeaderCell> */}
              </CTableRow>
            </CTableHead>
            <CTableBody>
              {data.content.map((v, i) => (
                <CTableRow key={v.userHeaderId.companyId + '' + v.userHeaderId.userId}>
                  {/* <CTableHeaderCell scope="row">
                    {v.userHeaderId.companyId + '' + v.userHeaderId.userId}
                  </CTableHeaderCell> */}
                  <CTableDataCell>{v.userHeaderId.companyId}</CTableDataCell>
                  <CTableDataCell>{v.userHeaderId.userId}</CTableDataCell>
                  <CTableDataCell>{v.username}</CTableDataCell>
                  {/* <CTableDataCell>{v.password}</CTableDataCell> */}
                  {/* <CTableDataCell>{v.expireDate}</CTableDataCell> */}
                  <CTableDataCell>{v.groupId}</CTableDataCell>
                  <CTableDataCell>{v.department}</CTableDataCell>
                  <CTableDataCell>{v.userTel1}</CTableDataCell>
                  {/* <CTableDataCell>{v.userTel2}</CTableDataCell> */}
                  <CTableDataCell>{v.userEmail}</CTableDataCell>
                  <CTableDataCell>{v.userLangauge}</CTableDataCell>
                  <CTableDataCell>{v.flightRefreshInterval}</CTableDataCell>
                  <CTableDataCell>{v.remarks}</CTableDataCell>
                  <CTableDataCell>{v.status}</CTableDataCell>
                  {/* <CTableDataCell>{v.updatedBy}</CTableDataCell> */}
                  {/* <CTableDataCell>{new Date(v.updatedDate).toDateString()}</CTableDataCell> */}
                </CTableRow>
              ))}
            </CTableBody>
          </CTable>
          <CPagination aria-label="pagination">
            <CPaginationItem {...(data.content.first ? 'disabled' : '')}>Previous</CPaginationItem>
            <CPaginationItem>1</CPaginationItem>
            <CPaginationItem>2</CPaginationItem>
            <CPaginationItem>3</CPaginationItem>
            <CPaginationItem>Next</CPaginationItem>
          </CPagination>
        </CCardBody>
      </CCard>
    )
  }

  return loading
    ? renderLoading()
    : error
    ? renderError()
    : data.length === 0
    ? renderEmpty()
    : renderData()
}

export default New
