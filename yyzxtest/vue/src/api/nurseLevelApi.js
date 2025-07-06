import http from '@/request/request.js'

function findAllNursingLevelPage(data){
    return http.get('/nursingLevel/findAllNursingLevelPage',{params:data})
}
function UpdateNursingLevel(data){
    return http.post('/nursingLevel/UpdateNursingLevel',data)
}
function addNursingLevel(data){
    return http.post('/nursingLevel/addNursingLevel',data)
}
function findAllNursingLevel(data){
    return http.get('/nursingLevel/findAllNursingLevel',{params:data})
}
export {
    findAllNursingLevelPage,
    UpdateNursingLevel,
    addNursingLevel,
    findAllNursingLevel
}