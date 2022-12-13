import swal from "sweetalert";
import axios from "axios";
import { useState, useEffect} from "react";
import { useNavigate, Link, useParams } from "react-router-dom";


//const URI = "http://localhost:8080/paciente/";
const URI = "http://150.136.150.224:8080/consultorio/paciente/";


let headers = {
    "usuario": sessionStorage.getItem("usuario"),
    "clave": sessionStorage.getItem("clave"),
    "id": sessionStorage.getItem("id"),
}



const Registro = () => {
    const navigate = useNavigate();
    const [iden, setCod_paciente] = useState("");
    const [nom, setNombre_paciente] = useState("");
    const [apell, setApellido_paciente] = useState("");
    const [ciu, setCiudad_paciente] = useState("");
    const [dire, setDirecc_paciente] = useState("");
    const [f_na, setFecha_naci_paciente] = useState("");
    const [tel, setTel_paciente] = useState("");
    const [ema, setEmail_paciente] = useState("");
    const [usu, setUsuario_paciente] = useState("");
    const [cla, setClave_paciente] = useState("");

    const handleCedula = (event) =>{
        const identificacion = event.target.value;
        setCod_paciente(identificacion);
    }

    const handleNombre = (event) =>{
        const nombre = event.target.value;
        setNombre_paciente(nombre);
    }

    const handleApellido = (event) =>{
        const apellido = event.target.value;
        setApellido_paciente(apellido);
    }

    const handleCiudad = (event) =>{
        const ciudad = event.target.value;
        setCiudad_paciente(ciudad);
    }

    const handleDireccion = (event) =>{
        const direccion = event.target.value;
        setDirecc_paciente(direccion);
    }

    const handleFecha = (event) =>{
        const f_nacimiento = event.target.value;
        setFecha_naci_paciente(f_nacimiento);
    }

    const handleTel = (event) =>{
        const telefono = event.target.value;
        setTel_paciente(telefono);
    }

    const handleEmail = (event) =>{
        const email = event.target.value;
        setEmail_paciente(email);
    }

    const handleUsuario = (event) =>{
        const usuario = event.target.value;
        setUsuario_paciente(usuario);
    }

    const handleClave = (event) =>{
        const clave = event.target.value;
        setClave_paciente(clave);
    }

    const submitPaciente = async (e) => {
        e.preventDefault();
        const data = { 
            identificacion: iden,
            nombre: nom,
            apellido: apell,
            ciudad: ciu,
            direccion: dire,
            f_nacimiento: f_na,
            telefono: tel,
            email: ema,
            usuario: usu,
            clave: cla
          }

        await axios.post(URI, JSON.stringify(data))
          .then(res => {console.log(res)});
    }


    return(
        <div className="container col-4">
            <form onSubmit={submitPaciente} className="form">
                <div className="mb-3">
                    <label className="form-label">Cédula: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleCedula(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Nombre: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleNombre(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Apellido: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleApellido(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Ciudad: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleCiudad(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Dirección: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleDireccion(e)}
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Fecha Nacimiento: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleFecha(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Teléfono: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleTel(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Email: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleEmail(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Usuario: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleUsuario(e)}

                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Clave: </label>
                    <input
                        className="form-control"
                        onChange={(e) => handleClave(e)}

                    />
                </div>
                
                <button className="btn btn-primary" type="submit">
                    Guardar
                </button>
            </form>
        </div>
   
    );

};

export default Registro;