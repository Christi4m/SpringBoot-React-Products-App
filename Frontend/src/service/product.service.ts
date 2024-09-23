import axios from "axios";

const API_URL = import.meta.env.VITE_BACKEND_URL;
// Obtener productos desde la API
export const fetchProductsService = async (token: string) => {
  const response = await axios.get(`${API_URL}/api/product`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return response.data;
};

// Crear un producto nuevo
export const createProductService = async (product: any, token: string) => {
  const response = await axios.post(`${API_URL}/api/product`, product, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return response.data;
};
