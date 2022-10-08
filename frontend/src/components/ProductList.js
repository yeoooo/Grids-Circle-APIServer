import React from "react";
import {Product} from "./Product";
import {useEffect, useState} from "react";
import axios from "axios";
import "../assets/static/ProductList.css"


export function ProductList({products = [], onAddClick, onRemoveClick, setTargetCategory} ) {

    const [categories, setCategory] = useState([]);

    useEffect(() => {

        axios.get('http://localhost:8080/api/v1/category')
            .then(v => setCategory(v.data.data)
                );
    }, []);

  return (
    <React.Fragment>
    <h5 className="flex-grow-0"><b>상품 목록</b></h5>
    <div className="row">
        <div className="col">
            <a className="col btn btn-sm btn-outline-dark" style={{fontSize:"13px"}} onClick={() => setTargetCategory("")}>{"전체"}</a>
        </div>
        {categories.map(v =>
        <div className="col">
                <a key={v} className="col btn btn-sm btn-outline-dark" style={{fontSize:"13px"}} onClick={() => setTargetCategory(v)}>
                    {v}
                </a>
        </div>
            )}
    </div>
      <ul className="list-group products">
        {products.map(v =>
          <li key={v.productId} className="list-group-item d-flex mt-3">
            <Product {...v} onAddClick={onAddClick} onRemoveClick={onRemoveClick}/>
          </li>
        )

        }
      </ul>
    </React.Fragment>
  )
}