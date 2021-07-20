import { createStore } from 'redux'

const initialState = {
  user: localStorage.getItem('auth-token'),
  sidebarShow: false,
}

const changeState = (state = initialState, { type, ...rest }) => {
  switch (type) {
    case 'set':
      return { ...state, ...rest }
    case 'login':
      return { ...state, ...rest }
    default:
      return state
  }
}

const store = createStore(changeState)
export default store
