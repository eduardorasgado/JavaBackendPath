package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public abstract class CarFactory {

    protected abstract Car create(String model, int year, String color);

    public static Properties.Builder newPropertiesBuilder() {
        return new Properties().new Builder();
    }

    public static class Properties {

        private String model;
        private int year;
        private String color;

        private Properties() {
            model = null;
            year = 0;
            color = null;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }

        public String getColor() {
            return color;
        }

        public class Builder {

            private Builder() {
            }

            public Builder setModel(String model) {
                Properties.this.model = model;
                return this;
            }

            public Builder setYear(int year) {
                Properties.this.year = year;
                return this;
            }

            public Builder setColor(String color) {
                Properties.this.color = color;
                return this;
            }

            public Properties build()  {
                if(model == null || year == 0 || color == null) {
                    throw new IllegalStateException("Properties not fully initialized.");
                }

                return Properties.this;
            }
        }
    }
}
