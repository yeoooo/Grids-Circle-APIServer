import React from "react";

export function Product(props) {
  const productId = props.productId;
  const productName = props.productName;
  const category = props.category;
  const price = props.price;
  const quantity = props.quantity;


  const handleAddBtnClicked = e => {
    props.onAddClick(productId);
  };
  const handleRemoveBtnClicked = e => {
      props.onRemoveClick(productId);
    };

  return <>
    {/*<div className="col-2">*/}
    {/*  <img className="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg" alt=""/>*/}
    {/*</div>*/}

    <div className="col-2">
      <img className="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg" alt=""/>
    </div>
    <div className="col-4">
      <div className="row text-muted"
           style={{fontSize: "10px"}}>
        카테고리
      </div>
      <div className="row">{category}</div>
    </div>
    {/*-------------------------------------------------------------------------*/}
    {/*<div className="col">*/}
    {/*  <div className="row text-muted">{category}</div>*/}
    {/*  <div className="row">{productName}</div>*/}
    {/*</div>*/}
    <div className="col">
      <div className="row text-muted"
           style={{fontSize: "10px"}}>
        제품명
      </div>
      <div className="row">{productName}</div>
    </div>
    {/*--------------------------------------------------------------------*/}
    {/*<div className="col text-center price">{price}원</div>*/}
    <div className="col-1">
        <div className="row text-muted"
             style={{fontSize: "10px"}}>가격
        </div>
        <div className="row">{price}원</div>
    </div>
    {/*{--------------------------------------------------------------------}*/}
    {/*<div className="col text-end action">*/}
    <div className="col">
      <button onClick={handleAddBtnClicked} className="btn btn-small btn-outline-dark"
              style={{fontSize: "13px",
                      marginRight: "1px"}}>
        추가
      </button>
        {/*<a className="btn btn-sm btn-outline-dark" style="font-size: 13px" >추가</a>*/}
    </div>
    <div className="col-1">
      <button onClick={handleRemoveBtnClicked} className="btn btn-small btn-outline-danger"
              style={{fontSize: "13px"}}>제거</button>
        {/*<a className="btn btn-sm btn-outline-danger" style="font-size: 13px" >제거</a>*/}
    </div>
    {/*</div>*/}

  </>
}