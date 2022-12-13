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

const Cita = () => {
    const navigate = useNavigate();
    const [citas, setCitas] = useState([]);
    useEffect(() => {
        getCitas()
    });

    const getCitas = async () =>{
        try {

            const res = await axios({
                method: "GET",
                url: URI + "consulta?idp="+sessionStorage.getItem("id")
            });

            setCitas(res.data)
            console.log(res.data)


        } catch (error) {
            swal("No tiene acceso a esta opción", "Presiona el botón", "error");
            navigate("/")
        }
    }

    return(

    <div className='container'>
        <div className='row'>
            <div className='col'>
                <table className='table'>
                    <thead className='table-primary'>
                        <tr>
                            <th>ID</th>
                            <th>Paciente</th>
                            <th>Medico</th>
                            <th>Fecha de la Cita</th>
                            <th>Descripción</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        { citas.map ((cita) => (
                          
                          <tr key={ cita.cod_cita}>
                                <td> { cita.cod_cita} </td>
                                <td> { cita.id_paciente.nombre} </td>
                                <td> { cita.id_medico.nombre} </td>
                                <td> { cita.fecha_registro }</td>
                                <td> { cita.decripcion }</td>
                                <td>
                                    <Link to={`/actualizar/${cita.cod_cita}`} className="btn btn-info">Actualizar</Link>
                                    <Link to={`/eliminar/${cita.cod_cita}`} className="btn btn-danger">Eliminar</Link>
                                </td>
                          </tr>
                        ))} 
                    </tbody>
    
                </table>
            </div>
        </div> 
    </div>
    );

};

export default Cita;