import React, {Component} from "react";
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";

import './App.css';
import 'bootstrap/dist/css/bootstrap.css';

import Main from "./pages/Main";
import Product from "./pages/productsInfo";

import Order from "./pages/order";


function App() {
  return (
      <div className="App">
      <BrowserRouter>
          <header>
              <h1 className="site-heading text-center text-faded d-none d-lg-block">
                  <span className="site-heading-upper text-primary mb-3">the Caffe</span>
                  <span className="site-heading-lower">Grid & Circle</span>
              </h1>
          </header>
          <nav className="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
              <div className="container">
                  <a className="navbar-brand text-uppercase fw-bold d-lg-none" href="index.html">Start Bootstrap</a>
                  <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                          data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                          aria-expanded="false" aria-label="Toggle navigation"><span
                      className="navbar-toggler-icon"></span></button>
                  <div className="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul className="navbar-nav mx-auto">
                          <Link to="/">
                              <li className="nav-item px-lg-4">
                                  <div className="nav-link text-uppercase">Home</div>
                              </li>
                          </Link>
                      <Link to="/order">
                              <li className="nav-item px-lg-4">
                                  <div className="nav-link text-uppercase">Order</div>
                              </li>
                          </Link>
                      </ul>
                  </div>
              </div>
          </nav>
            <Routes>
                <Route path="/" element={<Main />}></Route>
                <Route path="/order" element={<Order />}></Route>
                {/*<Route path="/product" element={<Product />}></Route>*/}

            </Routes>
          </BrowserRouter>

      </div>

  );

};

// import React, { Component } from 'react';
// import { BrowserRouter, Routes, Route } from 'react-router-dom';
// import Header from './Header';
// import Main from './Main';
// import Product from './Product';
// import NotFound from './NotFound';
//
// function App (){
//     return (
//         <div className='App'>
//             <BrowserRouter>
//                 <Header />
//                 <Routes>
//                     <Route path="/" element={<Main />}></Route>
//                     <Route path="/product/*" element={<Product />}></Route>
//                     {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
//                     <Route path="*" element={<NotFound />}></Route>
//                 </Routes>
//             </BrowserRouter>
//         </div>
//     );
// };

export default App;
