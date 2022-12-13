import swal from "sweetalert";
import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";


//const URI = "http://localhost:8080/citas/";
const URI = "http://150.136.150.224:8080/consultorio/citas/";

let headers = {
    "usuario": sessionStorage.getItem("usuario"),
    "clave": sessionStorage.getItem("clave"),
    "id": sessionStorage.getItem("id"),
}



const NuevaCita = () => {
    const navigate = useNavigate();
    const [cod_paciente, setCod_paciente] = useState("");
    const [nombre_paciente, setNombre_paciente] = useState("");
    const [apellido_paciente, setApellido_paciente] = useState("");
    const [ciudad_paciente, setCiudad_paciente] = useState("");
    const [direcc_paciente, setDirecc_paciente] = useState("");
    const [fecha_naci_paciente, setFecha_naci_paciente] = useState("");
    const [tel_paciente, setTel_paciente] = useState("");
    const [email_paciente, setEmail_paciente] = useState("");
    const [usuario_paciente, setUsuario_paciente] = useState("");
    const [clave_paciente, setClave_paciente] = useState("");



    return(
        <div>
            <form>
                <div className="mb-3">
                    <label className="form-label">Cédula: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Nombre: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Apellido: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Ciudad: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Dirección: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Fecha Naciemiento: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Teléfono: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Email: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Clave: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Usuario: </label>
                    <textarea
                        className="form-control"
                    />
                </div>
            </form>
        </div>

   
    );

};

export default NuevaCita;