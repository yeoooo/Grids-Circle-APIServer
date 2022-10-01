import React from 'react';
import {useEffect, useState} from "react";
import axios from "axios";

export function ProductInfo(productInfo=[]) {

    const [products, setProducts] = useState([]);
    useEffect(() => {
        return () => {
            axios.get('http://localhost:8080/api/v1/products')
                .then(v => setProducts(v.data));
        };
    },[]);

    return (
        <>
            {products.map((v, index) => {
                if (index % 2 == 0) {
                    return <>(
                        <section className="page-section">
                            <div className="container">
                                <div className="product-item">
                                    <div className="product-item-title d-flex">
                                        <div className="bg-faded p-5 d-flex ms-auto rounded">
                                            <h2 className="section-heading mb-0">
                                                <span className="section-heading-upper">{v.category}</span>
                                                <span className="section-heading-lower">{v.productName}</span>
                                            </h2>
                                        </div>
                                    </div>
                                    <div className="product-item-description me-auto">
                                        <div className="bg-faded p-5 rounded">
                                            <p>
                                                {v.description}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>)}
                        })</>;
                } else {

                    return <>(
                        < section className="page-section">
                            <div className="container">
                                <div className="product-item">
                                    <div className="product-item-title d-flex">
                                        <div className="bg-faded p-5 me-auto d-flex rounded">
                                            <h2 className="section-heading mb-0">
                                                <span className="section-heading-upper">{v.category}</span>
                                                <span className="section-heading-lower">{v.productName}</span>
                                            </h2>
                                        </div>
                                    </div>
                                    <div className="product-item-description ms-auto">
                                        <div className="bg-faded p-5 rounded">
                                            <p>
                                                {v.description}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        )</>;
                }
            })})
        </>
    );
}
export default ProductInfo;