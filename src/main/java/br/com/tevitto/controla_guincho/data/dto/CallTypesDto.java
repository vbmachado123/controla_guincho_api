package br.com.tevitto.controla_guincho.data.dto;

import br.com.tevitto.controla_guincho.data.model.Category;
import br.com.tevitto.controla_guincho.data.model.OriginCall;

import java.util.List;

public class CallTypesDto {

    private List<CallTypeDto> call_types;
    private List<CategoryDto> categories;
    private List<DriverCallDto> drivers;
    private List<OriginCallDto> origins;
    private List<VehicleCallDto> vehicles;

    public List<CallTypeDto> getCall_types() {
        return call_types;
    }

    public void setCall_types(List<CallTypeDto> call_types) {
        this.call_types = call_types;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    public List<DriverCallDto> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverCallDto> drivers) {
        this.drivers = drivers;
    }

    public List<OriginCallDto> getOrigins() {
        return origins;
    }

    public void setOrigins(List<OriginCallDto> origins) {
        this.origins = origins;
    }

    public List<VehicleCallDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleCallDto> vehicles) {
        this.vehicles = vehicles;
    }
}
