// import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import {ProductList} from "../components/ProductList";
import {Summary} from "../components/Summary";
import axios from "axios";
import React, {useEffect, useState} from 'react';


export function Order() {
    const [products, setProducts] = useState([
        {productId: 'uuid-1', productName: '콜롬비아 커피 1', category: '커피빈', price: 5000, quantity: 300},
        {productId: 'uuid-2', productName: '콜롬비아 커피 2', category: '커피빈', price: 5000, quantity: 300},
        {productId: 'uuid-3', productName: '콜롬비아 커피 3', category: '커피빈', price: 5000, quantity: 300},

    ]);
    const [items, setItems] = useState([]);

    const handleAddClicked = productId => {
        const product = products.find(v => v.productId === productId);
        const found = items.find(v => v.productId === productId);
        let updatedItems;
        if (found) {
            updatedItems = items.map(v => {
                if (v.productId === productId) {
                    if (v.quantity-1 < v.count) {
                        alert("선택된 양이 재고보다 많습니다.")
                        return v;
                    } else {
                        return {...v, count: v.count + 1};
                    }
                } else {
                    return v;
                }
            });
        }else{
            updatedItems = [...items, {...product, count: 1}];
        }
        setItems(updatedItems);
    };

    const handleRemoveClicked = productId => {
        let flag = false;
        const updatedItems = items.map((v,index) => {
            if (v.productId === productId) {//배열의 탐색 값이 선택한 값과 일치하면
                if(v.count > 1) {//선택된 상품의 개수가 0 초과인 경우
                    flag = true;
                    return {...v, count: v.count -1}
                }else{//선택된 상품의 개수가 0 이하인 경우
                    setItems(items.filter((p) =>  p.productId !== productId ));
                    return;
                }
            }else{
                return v
            }
        });
        if(flag){
            setItems(updatedItems);
        }
    }

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/products')
            .then(v => setProducts(v.data));
    }, []);



    const handleOrderSubmit = (order) => {
        if (items.length === 0) {
            alert("아이템을 추가해 주세요!");
        } else {
            axios.post('http://localhost:8080/api/v1/orders', {
                email: order.email,
                address: order.address,
                postcode: order.postcode,
                orderItems: items.map(v => ({
                    productId: v.productId,
                    category: v.category,
                    price: v.price,
                    quantity: v.count
                }))
            }).then(
                v => alert("주문이 정상적으로 접수되었습니다."),
                e => {
                    alert("서버 장애");
                    console.error(e);
                })
        }
    }
    return <>(
        <div className="card">
            <div className="row">
                <div className="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
                    {/*<ProductList products={products} onAddClick={handleAddClicked} onRemoveClick={handleRemoveClicked}/>*/}
                    <ProductList products={products} onAddClick={handleAddClicked} onRemoveClick={handleRemoveClicked}/>

                </div>
                <div className="col-md-4 summary p-4">
                    <Summary items={items} onOrderSubmit={handleOrderSubmit}/>
                </div>
            </div>
        </div>
        {/*</Link>*/}
        )
        </>
}

export default Order;
