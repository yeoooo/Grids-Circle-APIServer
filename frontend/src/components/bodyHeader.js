import React from 'react'
import {Link, Router} from "react-router-dom";
// import {Link} from "react-router-dom";

export function BodyHeader() {
    return <>(
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
                        {/*<li className="nav-item px-lg-4"><a to="/" className="nav-link text-uppercase">Home</a></li>*/}
                        {/*<li className="nav-item px-lg-4"><a to ="/products" className="nav-link text-uppercase">Products</a></li>*/}
                        {/*<li className="nav-item px-lg-4"><a to ="/order" className="nav-link text-uppercase">Order</a></li>*/}
                            <Link to="/"><li>Home</li></Link>
                            {/*<Link to="/"><li className="nav-item px-lg-4 nav-link text-uppercase">Home</li></Link>*/}
                            {/*<li className="nav-item px-lg-4"><Link to ="/products" className="nav-link text-uppercase">Products</Link></li>*/}
                            {/*<li className="nav-item px-lg-4"><Link to ="/order" className="nav-link text-uppercase">Order</Link></li>*/}
                    </ul>
                </div>
            </div>
        </nav>
    </>
}


export default BodyHeader;

