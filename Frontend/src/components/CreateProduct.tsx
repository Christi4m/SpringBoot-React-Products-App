import { ErrorMessage, Field, FieldArray, Form, Formik } from "formik";
import { useState } from "react";
import { Alert, Breadcrumb } from "react-bootstrap";
import { IoIosArrowBack } from "react-icons/io";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import * as Yup from "yup";
import { createProduct } from "../store/product.slice";
import { AppDispatch } from "../store/store";

interface ProductData {
  price: number;
  color: string;
}

const CreateProduct = () => {
  const [showAlert, setShowAlert] = useState(false);
  const [showAlertError, setShowAlertError] = useState(false);
  const dispatch = useDispatch<AppDispatch>();
  const navigate = useNavigate();

  const initialValues = {
    name: "",
    brand: "",
    data: [{ price: 0, color: "" } as ProductData],
  };

  const validationSchema = Yup.object({
    name: Yup.string().required("El nombre es obligatorio"),
    brand: Yup.string().required("La marca es obligatoria"),
    data: Yup.array()
      .of(
        Yup.object().shape({
          price: Yup.number()
            .required("El precio es obligatorio")
            .min(0, "El precio debe ser mayor o igual a 0"),
          color: Yup.string().required("El color es obligatorio"),
        })
      )
      .required("Se deben agregar detalles del producto"),
  });

  const handleSubmit = async (values: typeof initialValues) => {
    setShowAlertError(false);
    try {
      await dispatch(createProduct(values)).unwrap();
      setShowAlert(true);

      setTimeout(() => {
        setShowAlert(false);
        navigate("/products");
      }, 1500);

      values.name = "";
      values.brand = "";
      values.data = [{ price: 0, color: "" }];
    } catch (error) {
      setShowAlertError(true);
    }
  };
  return (
    <div className="container mt-5">
      <Breadcrumb>
        <Breadcrumb.Item href="/products" onClick={() => navigate("/products")}>
          <IoIosArrowBack className="me-1" /> Productos
        </Breadcrumb.Item>
      </Breadcrumb>
      <h2 className="text-center">Crear Producto</h2>
      {showAlert && (
        <Alert variant="success" className="text-center">
          ¡Producto agregado exitosamente!
        </Alert>
      )}
      {showAlertError && (
        <Alert variant="danger" className="text-center">
          Error al registrar el producto
        </Alert>
      )}
      <div className="w-100 row d-flex align-items-center justify-content-center">
        <div className="col-12 col-sm-6">
          <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            {({ values }) => (
              <Form className="mt-4">
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    Nombre del Producto
                  </label>
                  <Field
                    name="name"
                    className="form-control"
                    placeholder="Nombre del producto"
                  />
                  <ErrorMessage
                    name="name"
                    component="div"
                    className="text-danger"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="brand" className="form-label">
                    Marca del Producto
                  </label>
                  <Field
                    name="brand"
                    className="form-control"
                    placeholder="Marca del producto"
                  />
                  <ErrorMessage
                    name="brand"
                    component="div"
                    className="text-danger"
                  />
                </div>
                <h5>Detalles del Producto</h5>
                <FieldArray name="data">
                  {({ push, remove }) => (
                    <>
                      {values.data.map((_, index) => (
                        <div key={index} className="d-flex mb-3 w-100">
                          <div className="me-2">
                            <label
                              htmlFor={`data.${index}.price`}
                              className="form-label"
                            >
                              Precio
                            </label>
                            <Field
                              name={`data.${index}.price`}
                              type="number"
                              className="form-control"
                              placeholder="Precio"
                            />
                            <ErrorMessage
                              name={`data.${index}.price`}
                              component="div"
                              className="text-danger"
                            />
                          </div>
                          <div className="me-2">
                            <label
                              htmlFor={`data.${index}.color`}
                              className="form-label"
                            >
                              Color
                            </label>
                            <Field
                              name={`data.${index}.color`}
                              type="text"
                              className="form-control"
                              placeholder="Color"
                            />
                            <ErrorMessage
                              name={`data.${index}.color`}
                              component="div"
                              className="text-danger"
                            />
                          </div>
                          <div className="  d-flex align-items-end justify-content-center">
                            <button
                              type="button"
                              className="btn btn-danger h-50"
                              onClick={() => remove(index)}
                            >
                              Eliminar
                            </button>
                          </div>
                        </div>
                      ))}
                      <button
                        type="button"
                        className="btn btn-secondary mb-3"
                        onClick={() => push({ price: 0, color: "" })}
                      >
                        Agregar Detalle
                      </button>
                    </>
                  )}
                </FieldArray>
                <div className="w-100 d-flex flex-row-reverse ">
                  <button type="submit" className="btn btn-primary">
                    Crear Producto
                  </button>
                </div>
              </Form>
            )}
          </Formik>
        </div>
      </div>
    </div>
  );
};

export default CreateProduct;
