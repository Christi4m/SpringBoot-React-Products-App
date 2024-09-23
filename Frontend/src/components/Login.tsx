import React from "react";
import { useDispatch } from "react-redux";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { login } from "../store/auth.slice"; // Importa la acción login
import { useNavigate } from "react-router-dom";
import { AppDispatch } from "../store/store";

const Login: React.FC = () => {
  const dispatch = useDispatch<AppDispatch>();
  const navigate = useNavigate();

  // Validación del formulario con Yup
  const validationSchema = Yup.object({
    username: Yup.string().required("El nombre de usuario es requerido"),
    password: Yup.string().required("La contraseña es requerida"),
  });
  const initialValues = {
    username: "",
    password: "",
  };
  // Manejo del envío del formulario
  const handleSubmit = async (values: {
    username: string;
    password: string;
  }) => {
    try {
      const result = await dispatch(login(values)).unwrap();
      if (result) {
        navigate("/products");
      }
    } catch (error) {
      console.error("Error al iniciar sesión:", error);
    }
  };

  return (
    <div className="vw-100 vh-100 d-flex align-items-center justify-content-center">
      <div className="container  w-25 ">
        <h2 className="text-center">Iniciar Sesión</h2>
        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={handleSubmit}
        >
          {({ isSubmitting }) => (
            <Form>
              <div className="mb-3">
                <label htmlFor="username" className="form-label">
                  Nombre de Usuario
                </label>
                <Field
                  type="text"
                  id="username"
                  name="username"
                  className="form-control"
                />
                <ErrorMessage
                  name="username"
                  component="div"
                  className="text-danger"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="password" className="form-label">
                  Contraseña
                </label>
                <Field
                  type="password"
                  id="password"
                  name="password"
                  className="form-control"
                />
                <ErrorMessage
                  name="password"
                  component="div"
                  className="text-danger"
                />
              </div>

              <button
                type="submit"
                className="btn btn-primary w-100"
                disabled={isSubmitting}
              >
                Iniciar Sesión
              </button>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default Login;
