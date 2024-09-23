import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ProductList from "./components/ProductList";
import CreateProduct from "./components/CreateProduct";
import Login from "./components/Login";
import ProtectedRoute from "./components/ProtectedRoute";
import NavigationBar from "./components/NavigationBar";
import { useSelector } from "react-redux";
import { RootState } from "./store/store";

const App = () => {
  const isAuthenticated = useSelector(
    (state: RootState) => state.auth.isAuthenticated
  );
  return (
    <Router>
      {isAuthenticated && <NavigationBar />}
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route
          path="/products"
          element={
            <ProtectedRoute>
              <ProductList />
            </ProtectedRoute>
          }
        />
        <Route
          path="/products/create"
          element={
            <ProtectedRoute>
              <CreateProduct />
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
