function (id){
    fetch(`/eliminar/${id}`
        method: 'DELETE',
        headers: {
        'Content-Type': 'application/json'
        }
    })
    .then(respuesta =>{
        if(respuesta.ok){
            location.reload();
        }else{
            alert("Error al eliminar la nota");
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });

}


function(id){
    fetch(`/${id}`
            method: 'PUT',
            headers: {
            'Content-Type': 'application/json'
            }
        })
        .then(respuesta =>{
            if(respuesta.ok){
                location.reload();
            }else{
                alert("Error al eliminar la nota");
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

}