import React from 'react';
import ReactDOM from 'react-dom/client';
import { createRoot } from "react-dom/client";
import './style/index.scss';
import App from './App';
import { store, persistor } from "./app/store";
import { ToastContainer } from "react-toastify";
// import "react-loader-spinner/dist/loader/css/react-spinner-loader.css";
import { PersistGate } from 'redux-persist/integration/react';
import { Provider } from 'react-redux';
// const root = ReactDOM.createRoot(document.getElementById('root'));

const container = document.getElementById("root");
const root = createRoot(container);

root.render(
  <Provider store={store}>
    <PersistGate loading={null} persistor={persistor}>
      <App />
    </PersistGate>
    <ToastContainer></ToastContainer>
  </Provider>
);