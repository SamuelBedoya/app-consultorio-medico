import swal from "sweetalert";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";


const Logout = () => {
    sessionStorage.removeItem("usuario")
    sessionStorage.removeItem("clave")
    sessionStorage.removeItem("id")

    const navigate = useNavigate();

    swal("Sesión Finalizada!", "Presiona el botón", "success");
    navigate("/");

    return (
        <div className="container">
            <br></br>
            <p>Sesión Finalizada</p>
        </div>
    );
}

export default Logout;