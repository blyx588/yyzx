import http from '@/request/request.js';
import {h} from "vue";
function noLevel(data){
    return http.post('/customer/noLevel',data)
}
function addCustomer(data){
    return http.post('/customer/addCustomer',data)
}
function getCustomerList(data){
    return http.get('/customer/viewCustomer',{params:data})
}

function updateLevelId(data){
    return http.post('/customer/updateLevelId',data)
}

function listkhxxPage(data){
    return http.get('/customer/listkhxxPage',{params:data})
}
//更新护理项目
function updateCustomer(data){
    return http.post('/customer/updateCustomer',data)
}
//删除护理项目
function delCustomer(data){
    return http.get('/customer/delCustomer',{params:data})
}
//查询系统用户信息
function findAllCustomer(data){
    return http.get('/customer/findAllCustomerPage',{params:data})
}

function noSteward(data){
    return http.post('/customer/noSteward',data)
}
function getCustomerByUserId(data){
    return http.get('/customer/getCustomerByUserId',{params:data})
}
export {
    addCustomer,
    getCustomerList,
    updateCustomer,
    delCustomer,
    findAllCustomer,
    listkhxxPage,
    noSteward,
    noLevel,
    updateLevelId,
    getCustomerByUserId
}