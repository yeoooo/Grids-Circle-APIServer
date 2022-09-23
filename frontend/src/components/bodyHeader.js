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
                            <Link to="/"><li>Home</li></Link>
                    </ul>
                </div>
            </div>
        </nav>
    </>
}


export default BodyHeader;

