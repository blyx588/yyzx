import http from '@/request/request.js'

function findAllCustomerNurseItemPage(data){
    return http.get('/customerNurseItem/findAllCustomerNurseItemPage',{params:data})
}

function saveCustomerNurseItem(data){
    return http.post('/customerNurseItem/saveCustomerNurseItem',data)
}
function deleted(data){
    return http.post('/customerNurseItem/deleted',data)
}
function getNurseItemByCustomer(data){
    return http.get('/customerNurseItem/getNurseItemByCustomer',{params:data})
}
export {
    findAllCustomerNurseItemPage,
    saveCustomerNurseItem,
    deleted,
    getNurseItemByCustomer
}