const url = "http://localhost:8080/medicamentos/"
const url1 = "http://localhost:8080/medicamentos/list/"

const contenedor = document.querySelector('tbody')

let resultados = ''

const modalMedicamentos = new bootsrap.Modal(document.getElementById('modalMedicamentos'))
const formMedicamentos = document.querySelector('form')
const idMedicamentos = document.getElementById('IDmedicamentos')
const fechaCita = document.getElementById('fechaCita')
const medicamentoFormulado = document.getElementById('medicamentoForm')
const descripcionMedicamento = document.getElementById('descripcionMedicamento')

let opcion = ''

btnFormular.addEventListener('click', () =>{

    idMedicamentos.value = ''
    idMedicamentos.disable = false
    fechaCita.value = ''
    medicamentoFormulado.value = ''
    descripcionMedicamento.value = ''
    modalMedicamentos.show()
    opcion = 'Formular'
})

btnCerrar.addEventListener('click', () => {

    modalMedicamentos.hide()
})