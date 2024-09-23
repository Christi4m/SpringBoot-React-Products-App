import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchProducts } from "../store/product.slice";
import { RootState, AppDispatch } from "../store/store";
import { useNavigate } from "react-router-dom";

const ProductList = () => {
  const dispatch = useDispatch<AppDispatch>();
  const products = useSelector((state: RootState) => state.products.products);
  const token = useSelector((state: RootState) => state.auth.token);
  const navigate = useNavigate();
  useEffect(() => {
    if (token) {
      dispatch(fetchProducts());
    }
  }, [dispatch, token]);

  const handleCreateProduct = () => {
    navigate("/products/create");
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center">Lista de Productos</h1>
      <div className="w-100 bg danger my-3 d-flex flex-row-reverse">
        <button
          onClick={handleCreateProduct}
          type="submit"
          className="btn btn-primary "
        >
          Agregar producto
        </button>
      </div>
      <div className="row">
        {products.map((product, index) => (
          <div className="col-md-4 mb-4 d-flex" key={index}>
            <div className="card flex-fill">
              <div className="card-body d-flex flex-column">
                <div>
                  <h5 className="card-title">{product.name}</h5>
                  <h6 className="card-subtitle mb-2 text-muted">
                    {product.brand}
                  </h6>
                </div>
                <ul className="list-group list-group-flush mt-3">
                  {product.data?.map((item, idx) => (
                    <li className="list-group-item" key={idx}>
                      <strong>Precio:</strong> ${item.price.toFixed(2)} <br />
                      <strong>Color:</strong> {item.color}
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductList;
