const url = "http://localhost:9090/formulas/"
const url1 = "http://localhost:9090/formulas/list/"

const contenedor = document.querySelector('tbody')

let resultados = ''

const formMedicamentos = document.querySelector('form')
const idCita = document.getElementById('IDcita')
const medicamentoFormulado = document.getElementById('medFormulado')
const descripcionMedicamento = document.getElementById('descripcion')
const codFormula = document.getElementById('codFormula')

let opcion = ''

btnFormular.addEventListener('click', () =>{

    idCita.value = ''
    medicamentoFormulado.value = ''
    descripcionMedicamento.value = ''
    $('#modalFormulas').modal('show');
    opcion = 'crear'
})


btnCerrar.addEventListener('click', () => {
    $('#modalFormulas').modal('hide');
})

btnCerrar2.addEventListener('click', () => {
    $('#modalFormulas').modal('hide');
})

const mostrar = (formulas) => {
    formulas.forEach(formu => {
        resultados += `<tr>
                        <td >${formu.cod_formula}</td>
                        <td >${formu.cita.cod_cita}</td>
                        <td >${formu.cita.decripcion}</td>
                        <td >${formu.cita.fecha_registro}</td>
                        <td >${formu.cita.id_paciente.nombre +" "+ formu.cita.id_paciente.apellido}</td>
                        <td >${formu.medicamentos_formulados}</td>
                        <td >${formu.descripcion}</td>
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
    const idCitas = fila.children[1].innerHTML 
    const medFormulados = fila.children[5].innerHTML 
    const descrip = fila.children[6].innerHTML 

    codFormula.value = idForm

    idCita.value = idCitas
    medicamentoFormulado.value = medFormulados
    descripcionMedicamento.value = descrip
    opcion = 'editar' 
    $('#modalFormulas').modal('show');
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




formMedicamentos.addEventListener('submit', (e) => { 
    e.preventDefault() 

        if (opcion == 'crear') { 
            fetch(url, { 
            method: 'POST', 
            headers: { 
                'Content-Type': 'application/json' 
            }, 
            body: JSON.stringify({ 
                cita: {cod_cita: idCita.value}, 
                medicamentos_formulados: medicamentoFormulado.value,
                descripcion: descripcionMedicamento.value
            }) 
        }) 
            .then(response => response.json()) 
            .then(data => { 
                const nuevaFormula = [] 
                nuevaFormula.push(data) 
                location.reload()
                mostrar(nuevaFormula) 
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
                cod_formula: codFormula.value, 
                cita: {cod_cita: idCita.value}, 
                medicamentos_formulados: medicamentoFormulado.value,
                descripcion: descripcionMedicamento.value
            })
                
        }) 
            .then(() => location.reload())
    } 

    $('#modalFormulas').modal('hide');
}) 