import swal from "sweetalert";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

//const URI = "http://localhost:8080/paciente/";
const URI = "http://150.136.150.224:8080/consultorio/paciente/";

const Login = () =>{
    const navigate = useNavigate();
    const [pacientes, setPacientes] = useState([]);
    const [usuario_paciente, setUsuario_paciente] = useState("");
    const [clave_paciente, setClave_paciente] = useState("");

    const guardar = async (e) => {
        e.preventDefault();

        try {
            const res = await axios({
                method: "GET",
                //url: URI + "list"
                url: URI + "login?usuario="+usuario_paciente+"&clave="+clave_paciente
            });
            setPacientes(res.data)
            if (res.data.usuario == null) {
                
                swal("Cliente no autorizado!", "Presiona el botón", "error");

            } else {
                sessionStorage.setItem("usuario", usuario_paciente);
                sessionStorage.setItem("clave", clave_paciente);   
                sessionStorage.setItem("id", res.data.id_paciente);  
                swal("Bienvido "+res.data.nombre+"!", "Presiona el botón", "success");
                navigate("/");
            }

        } catch (error) {
            swal("Operación NO realizada");
        }
    };

    return(
        <div>
        <h3>Login</h3>
        <div className="container col-2">
        <form onSubmit={guardar}>
    
            <div className="mb-3">
                <label className="form-label">Usuario</label>
                <input
                    value={usuario_paciente}
                    onChange={(e) => setUsuario_paciente(e.target.value)}
                    type = "text"
                    maxLength={15}
                    required 
                    onInvalid={e => e.target.setCustomValidity('El campo Usuario es obligatorio')}
                    onInput = {e => e.target.setCustomValidity('')}
                    className="form-control"
            />
            </div>
            <div className="mb-3">
                <label className="form-label">Clave</label>
                <input
                    value={clave_paciente}
                    onChange={(e) => setClave_paciente(e.target.value)}
                    type="password"
                    maxLength={50}
                    required
                    onInvalid={e => e.target.setCustomValidity('El campo Clave es obligatorio')}
                    onInput={e => e.target.setCustomValidity('')}
                    className="form-control"
                />
            </div>
            <button type="submit" className="btn btn-primary">
            Login
            </button>
        </form>
    </div>
    </div> 
    );
};

export default Login;