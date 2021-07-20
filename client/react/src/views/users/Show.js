import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
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

const Show = (props) => {
  const [error, setError] = useState(false)
  const [data, setData] = useState([])
  const [loading, setLoading] = useState(false)
  const { companyId, userId } = useParams()

  useEffect(() => {
    fetchData()
    return () => {
      console.log('CLEANING')
    }
  }, [])

  const fetchData = async () => {
    try {
      setLoading(true)
      const response = await fetchOneUser({ companyId, userId })
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
                <CTableHeaderCell scope="col">Password</CTableHeaderCell>
                <CTableHeaderCell scope="col">Expire Date</CTableHeaderCell>
                <CTableHeaderCell scope="col">Group Id</CTableHeaderCell>
                <CTableHeaderCell scope="col">Department</CTableHeaderCell>
                <CTableHeaderCell scope="col">Tel1</CTableHeaderCell>
                <CTableHeaderCell scope="col">User Tel 2</CTableHeaderCell>
                <CTableHeaderCell scope="col">Email</CTableHeaderCell>
                <CTableHeaderCell scope="col">Language</CTableHeaderCell>
                <CTableHeaderCell scope="col">Flight Refresh Interval</CTableHeaderCell>
                <CTableHeaderCell scope="col">Remarks</CTableHeaderCell>
                <CTableHeaderCell scope="col">Status</CTableHeaderCell>
                <CTableHeaderCell scope="col">Updated By</CTableHeaderCell>
                <CTableHeaderCell scope="col">Updated Date</CTableHeaderCell>
              </CTableRow>
            </CTableHead>
            <CTableBody>
              <CTableRow key={data.userHeaderId.companyId + '' + data.userHeaderId.userId}>
                <CTableHeaderCell scope="row">
                  {data.userHeaderId.companyId + '' + data.userHeaderId.userId}
                </CTableHeaderCell>
                <CTableDataCell>{data.userHeaderId.companyId}</CTableDataCell>
                <CTableDataCell>{data.userHeaderId.userId}</CTableDataCell>
                <CTableDataCell>{data.username}</CTableDataCell>
                <CTableDataCell>{data.password}</CTableDataCell>
                <CTableDataCell>{data.expireDate}</CTableDataCell>
                <CTableDataCell>{data.groupId}</CTableDataCell>
                <CTableDataCell>{data.department}</CTableDataCell>
                <CTableDataCell>{data.userTel1}</CTableDataCell>
                <CTableDataCell>{data.userTel2}</CTableDataCell>
                <CTableDataCell>{data.userEmail}</CTableDataCell>
                <CTableDataCell>{data.userLangauge}</CTableDataCell>
                <CTableDataCell>{data.flightRefreshInterval}</CTableDataCell>
                <CTableDataCell>{data.remarks}</CTableDataCell>
                <CTableDataCell>{data.status}</CTableDataCell>
                <CTableDataCell>{data.updatedBy}</CTableDataCell>
                <CTableDataCell>{new Date(data.updatedDate).toDateString()}</CTableDataCell>
              </CTableRow>
            </CTableBody>
          </CTable>
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

export default Show
