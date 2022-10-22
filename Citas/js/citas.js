const url = "http://localhost:8080/citas/"
const url1 = "http://localhost:8080/citas/list/"

const contenedor = document.querySelector('tbody')

let resultados = ''

const modalCitas = new bootsrap.Modal(document.getElementById('modalCitas'))
const formCitas = document.querySelector('form')
const idCitas = document.getElementById('IDcita')
const fechaCitas = document.getElementById('fechaCita')
const nombreMedico = document.getElementById('nombreMedico')
const descripcionCitas = document.getElementById('descripcion')

let opcion = ''

btnAgendar.addEventListener('click',() => {

    idCitas.value = ''
    idCitas.disabled = false 
    fechaCitas.value = ''
    nombreMedico.value = ''
    descripcionCitas.value = ''
    modalCitas.show()
    opcion = 'Agendar'
})

btnCerrar.addEventListener('click', () => {

    modalCitas.hide()
})

const mostrar(citas) => {
    citas.forEach(citas => {
        resultados += `<tr>
                        <td >${citas.cod_cita}</td>
                        <td >${citas.id_paciente}</td>
                        <td >${citas.fecha_cita}</td>
                        <td >${citas.id_medico}</td>
                        <td >${citas.descrip}</td>
                        <td class="text-center" width="20%"><a
class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btndanger">Borrar</a></td>
</tr>`
    })


}
