import React, { useEffect, useState } from 'react';
import { getRoomTypes } from '../utils/ApiFunctions';

const RoomTypeSelector = ({handleRoomInputChange, newRoom}) => {
    const [roomTypes, setRoomTypes] = useState([""])
    const [showNewRoomTypesInput, setShowNewRoomTypesInput] = useState(false)
    const [newRoomType, setNewRoomType] = useState("")

    useEffect(() => {
        getRoomTypes().then((data) =>{
            setRoomTypes(data)})
    }, [])

    const handleNewRoomTypeInputChange = (e) =>{
        setNewRoomType(e.target.value);
    }
    const handelAddNewRoomType = () =>{
        if(newRoomType !==""){
            setRoomTypes([...roomTypes, newRoomType])
            setNewRoomType("")
            setShowNewRoomTypesInput(false)
        }
    }
    return (
        <>
        {roomTypes.length > 0 &&(
            <div>
                <select name="roomType" id="roomType" value={newRoom.roomTypes} onChange={(e)=>{
                    if(e.target.value ==="Add New"){
                        setShowNewRoomTypesInput(true)
                    }else{
                        handleRoomInputChange(e)
                    }
                }}>
                    <option value={""}> Select a new Room type</option>
                    <option value={"Add New"}>Add New</option>
                    {roomTypes.map((type, index) =>(
                        <option key={index} value={type}>{type}</option>
                    ))}
                </select>
                {showNewRoomTypesInput && (
                    <div className='input-group'>
                        <input type="text" className='form-control' placeholder='Enter new room type' onChange={handleNewRoomTypeInputChange}/>
                        <button className='btn btn-primary' type='button' onClick={handelAddNewRoomType}>Add</button>
                    </div>
                )}
            </div>
        )}
        </>
    );
};

export default RoomTypeSelector;