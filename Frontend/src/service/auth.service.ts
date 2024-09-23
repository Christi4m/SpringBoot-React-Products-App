import axios from 'axios';

// Obtener la URL del backend desde las variables de entorno
const backendUrl = import.meta.env.VITE_BACKEND_URL;

export const loginService = async (credentials: { username: string; password: string }) => {
    const response = await axios.post(`${backendUrl}/api/auth/login`, credentials);
    return response.data.token;
};
