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
import { fetchAllCustomers, fetchOneCustomer } from '../../api/app-client'

const Customers = () => {
  const [error, setError] = useState(false)
  const [data, setData] = useState([])
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    return () => {
      console.log('CLEANING')
    }
  }, [])

  const fetchData = async () => {
    try {
      const response = await fetchAllCustomers()
      if (response.data) {
        setData(response.data)
      }
    } catch (e) {
      console.log(e)
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
    return renderData()
    // return (
    //   <div className="card">
    //     <div className="card-body">No data</div>
    //   </div>
    // )
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
                <CTableHeaderCell scope="col">#</CTableHeaderCell>
                <CTableHeaderCell scope="col">Class</CTableHeaderCell>
                <CTableHeaderCell scope="col">Heading</CTableHeaderCell>
                <CTableHeaderCell scope="col">Heading</CTableHeaderCell>
              </CTableRow>
            </CTableHead>
            <CTableBody>
              <CTableRow>
                <CTableHeaderCell scope="row">1</CTableHeaderCell>
                <CTableDataCell>Mark</CTableDataCell>
                <CTableDataCell>Otto</CTableDataCell>
                <CTableDataCell>@mdo</CTableDataCell>
              </CTableRow>
              <CTableRow>
                <CTableHeaderCell scope="row">2</CTableHeaderCell>
                <CTableDataCell>Jacob</CTableDataCell>
                <CTableDataCell>Thornton</CTableDataCell>
                <CTableDataCell>@fat</CTableDataCell>
              </CTableRow>
              <CTableRow>
                <CTableHeaderCell scope="row">3</CTableHeaderCell>
                <CTableDataCell colspan="2">Larry the Bird</CTableDataCell>
                <CTableDataCell>@twitter</CTableDataCell>
              </CTableRow>
            </CTableBody>
          </CTable>
          <CPagination aria-label="Page navigation example">
            <CPaginationItem disabled>Previous</CPaginationItem>
            <CPaginationItem active>1</CPaginationItem>
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

export default Customers
