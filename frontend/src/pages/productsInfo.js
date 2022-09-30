import React from 'react';
import p3 from '../assets/img/products-03.jpg'
import p2 from '../assets/img/products-02.jpg'
import p1 from '../assets/img/products-01.jpg'
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
                                                {/*<span className="section-heading-upper">Blended to Perfection</span>*/}
                                                <span className="section-heading-upper">{v.category}</span>
                                                <span className="section-heading-lower">{v.productName}</span>
                                            </h2>
                                        </div>
                                    </div>
                                    {/*<img className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-5" src={p1} alt="..." />*/}
                                    <div className="product-item-description d-flex me-auto">
                                        <div className="bg-faded p-5 rounded">
                                            <p className="mb-0">We take pride in our work, and it shows. Every time you
                                                order a
                                                beverage from us, we guarantee that it will be an experience worth having.
                                                Whether it's our world famous Venezuelan Cappuccino, a refreshing iced
                                                herbal
                                                tea, or something as simple as a cup of speciality sourced black coffee, you
                                                will be coming back for more.</p>
                                            {/*<p>*/}
                                            {/*    {v.description}*/}
                                            {/*</p>*/}
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
                                        <div className="bg-faded p-5 d-flex me-auto rounded">
                                            <h2 className="section-heading mb-0">
                                                {/*<span className="section-heading-upper">Delicious Treats, Good Eats</span>*/}
                                                {/*<span className="section-heading-lower">Bakery & Kitchen</span>*/}
                                                <span className="section-heading-upper">{v.category}</span>
                                                <span className="section-heading-lower">{v.productName}</span>
                                            </h2>
                                        </div>
                                    </div>
                                    {/*<img className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src={p2} alt="..." />*/}
                                    <div className="product-item-description d-flex ms-auto">
                                        <div className="bg-faded p-5 rounded">
                                            <p className="mb-0">
                                                Our seasonal menu features delicious snacks, baked goods, and even full
                                                meals
                                                perfect for breakfast or lunchtime. We source our ingredients from
                                                local, oragnic
                                                farms whenever possible, alongside premium vendors for specialty goods.
                                            </p>
                                            {/*<p>*/}
                                            {/*    {v.description}*/}
                                            {/*</p>*/}
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