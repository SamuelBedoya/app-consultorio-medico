const url = "http://localhost:9090/citas/"
const url1 = "http://localhost:9090/citas/list/"

const contenedor = document.querySelector('tbody')

let resultados = ''

// const modalCitas = new bootsrap.Modal(document.getElementById('modalCitas'))
const modalCitas = document.getElementById('modalCitas')
const formCitas = document.querySelector('form')
const idMedico = document.getElementById('IdMedico')
const idPaciente = document.getElementById('IdPaciente')
const fechaCita = document.getElementById('FechaCita')
const descripcionCitas = document.getElementById('descripcion')

let opcion = ''

btnAgendar.addEventListener('click',() => {

    idMedico.value = ''
    idPaciente.value = ''
    fechaCita.value = ''
    descripcionCitas.value = ''
    $('#modalCitas').modal('show');
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {
    $('#modalCitas').modal('hide');
})

btnCerrar2.addEventListener('click', () => {
    $('#modalCitas').modal('hide');
})

const mostrar = (citas) => {
    citas.forEach(cita => {
        resultados += `<tr>
                        <td >${cita.cod_cita}</td>
                        <td hidden>${cita.id_paciente.id_paciente}</td>
                        <td hidden>${cita.id_medico.id_medico}</td>
                        <td >${cita.id_paciente.nombre}</td>
                        <td >${cita.id_medico.nombre}</td>
                        <td >${cita.fecha_registro}</td>
                        <td >${cita.decripcion}</td>
                        <td class="text-center" width="20%"><a
class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btndanger">Borrar</a></td>
</tr>`
    })

    contenedor.innerHTML = resultados

}

fetch(url1)
    .then(response => response.json()) 
    .then(data => mostrar(data)) 
    .catch(error => console.log(error)) 

const on = (element, event, selector, handler) => { 
    element.addEventListener(event, e => { 
        if (e.target.closest(selector)) 
            handler(e) 
    }) 
} 

let idForm = 0 
on(document, 'click', '.btnEditar', e => { 
    const fila = e.target.parentNode.parentNode 
    idForm = fila.children[0].innerHTML 
    const nombrePaciente = fila.children[1].innerHTML 
    const nombreMedico = fila.children[2].innerHTML 
    const fecha = fila.children[5].innerHTML 
    const desc = fila.children[6].innerHTML 

    
    idMedico.value = nombreMedico
    idPaciente.value = nombrePaciente
    fechaCita.value = fecha
    descripcionCitas.value = desc
    opcion = 'editar' 
    $('#modalCitas').modal('show');
}) 

on(document, 'click', '.btnBorrar', e => { 
    const fila = e.target.parentNode.parentNode 
    const id = fila.firstElementChild.innerHTML
    console.log(id) 
    
alertify.confirm("Desea eliminar la cita "+id, 
    function () { 
        fetch(url + id, { 
            method: 'DELETE' 
        }) 
            .then(() => location.reload())

            
    }, 
    function () { 
        alertify.error('Cancelado') 
    }); 
    
}) 




formCitas.addEventListener('submit', (e) => { 
    e.preventDefault() 

        if (opcion == 'crear') { 
            fetch(url, { 
            method: 'POST', 
            headers: { 
                'Content-Type': 'application/json' 
            }, 
            body: JSON.stringify({ 
                id_medico: {id_medico: idMedico.value}, 
                id_paciente: {id_paciente: idPaciente.value},
                decripcion: descripcionCitas.value,
                fecha_registro: fechaCita.value
            }) 
        }) 
            .then(response => response.json()) 
            .then(data => { 
                const nuevaCita = [] 
                nuevaCita.push(data) 
                mostrar(nuevaCita) 
                location.reload()
        }) 
            
    } 
    if (opcion == 'editar') { 
        fetch(url, { 
            method: 'PUT', 
            headers: { 
                'Content-Type': 'application/json' 
            }, 
            body: JSON.stringify({ 
                idProveedor: idForm, 
                nombreProveedor: nombreProveedor.value, 
                emailProveedor: emailProveedor.value 
            }) 
        }) 
            .then(response => location.reload()) 
    } 

    $('#modalCitas').modal('hide');
}) 