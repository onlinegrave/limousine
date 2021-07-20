import store from '../store'
// etither set proxy or use this value
import { useDispatch } from 'react-redux'
const ENDPOINT = 'http://localhost:8081'

export const login = ({ companyId, userId, password }) => {
  const data = {
    username: companyId + ' ' + userId,
    password,
  }

  const url = '/authenticate'
  return _request(url, {
    method: 'POST',
    data: data,
    auth: false,
  })
}

export const fetchAllCustomers = (data) => {
  const url = '/customerheaders'
  return _request(url, {
    method: 'GET',
    data: data,
    auth: true,
  })
}

export const fetchOneCustomer = (data) => {
  const url = '/customerheaders'
  return _request(url, {
    method: 'GET',
    data: data,
    auth: true,
  })
}

export const createCustomer = (data) => {
  const url = '/customerheaders'
  return _request(url, {
    method: 'POST',
    data: data,
    auth: true,
  })
}

export const deleteCustomer = (data) => {
  const url = '/customerheaders'
  return _request(url, {
    method: 'DELETE',
    data: data,
    auth: true,
  })
}

export const editCustomer = (data) => {
  const url = '/customerheaders'
  return _request(url, {
    method: 'PATCH',
    data: data,
    auth: true,
  })
}

export const fetchAllUsers = ({ page, size, orderBy, order, data }) => {
  const url = `/userheaders?page=${page}&size=${size}&orderBy=${orderBy}&order=${order}`
  return _request(url, {
    method: 'GET',
    data: data,
    auth: true,
  })
}

export const fetchOneUser = ({ companyId, userId, data }) => {
  const url = `/userheaders/${companyId}/${userId}`
  return _request(url, {
    method: 'GET',
    data: data,
    auth: true,
  })
}

export const createUser = (data) => {
  const url = '/userheaders'
  return _request(url, {
    method: 'POST',
    data: data,
    auth: true,
  })
}

export const deleteUser = (data) => {
  const url = '/userheaders'
  return _request(url, {
    method: 'DELETE',
    data: data,
    auth: true,
  })
}

export const editUser = (data) => {
  const url = '/userheaders'
  return _request(url, {
    method: 'PATCH',
    data: data,
    auth: true,
  })
}

const _request = async (url, { method, data, auth = false }) => {
  try {
    const myHeaders = new Headers()
    myHeaders.append('Content-Type', 'application/json')

    if (auth) {
      const authToken = localStorage.getItem('auth-token')
      myHeaders.append('Authorization', `Bearer ${localStorage.getItem('auth-token')}`)
    }
    const raw = JSON.stringify(data)
    let response = null
    console.log('BREAK!')
    switch (method) {
      case 'GET':
        response = await _get(url, myHeaders, raw)
        break
      case 'POST':
        response = await _post(url, myHeaders, raw)
        break
      case 'PUT':
        response = await _put(url, myHeaders, raw)
        break
      case 'PATCH':
        response = await _patch(url, myHeaders, raw)
        break
      case 'DELETE':
        response = await _delete(url, myHeaders, raw)
        break
      default:
        throw new Error('Invalid METHOD')
    }
    try {
      if (response.status === 403 || response.status === 401) {
        handleAuthError()
        return
      }
      const response_json = await response.json()
      if (response_json.error) {
        throw response_json
      }
      if (response_json.data) {
        return response_json
      }
    } catch (e) {
      try {
        console.log('error occured')
        await handleError(e)
      } catch (e) {
        console.log('error caught and thrown')
        throw e
      }
    }
  } catch (e) {
    console.log('Something went wrong')
  }
}

const _get = async (url, headers, raw) => {
  const requestOptions = {
    method: 'GET',
    headers: headers,
    body: raw,
    redirect: 'follow',
  }
  return await fetch(url, requestOptions)
}

const _post = async (url, headers, raw) => {
  const requestOptions = {
    method: 'POST',
    headers: headers,
    body: raw,
    redirect: 'follow',
  }
  return await fetch(url, requestOptions)
}

const _delete = async (url, headers, raw) => {
  const requestOptions = {
    method: 'POST',
    headers: headers,
    body: raw,
    redirect: 'follow',
  }
  return await fetch(url, requestOptions)
}

const _put = async (url, headers, raw) => {
  const requestOptions = {
    method: 'PUT',
    headers: headers,
    body: raw,
    redirect: 'follow',
  }
  return await fetch(url, requestOptions)
}

const _patch = async (url, headers, raw) => {
  const requestOptions = {
    method: 'PATCH',
    headers: headers,
    body: raw,
    redirect: 'follow',
  }
  return await fetch(url, requestOptions)
}

const handleAuthError = async (e) => {
  console.log('handing auth error')
  localStorage.removeItem('auth-token')
  store.dispatch({ type: 'set', user: null })
}

const handleError = async (e) => {
  console.log(`handling error ${e.error}`)
  switch (e) {
    case 'Auth error':
      console.log('Redirect to login')
      break
    default:
      throw e
  }
}
