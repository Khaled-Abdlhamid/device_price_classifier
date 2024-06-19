from flask import Flask, request, jsonify
import pickle
import pandas as pd

app = Flask(__name__)

# Loading the prediction model
with open("C:/Users/LENOVO/Downloads/device-price-predictor/flask/device_price_classifier.pkl", "rb") as file:
    model = pickle.load(file)

@app.route('/predict', methods=['GET'])
def predict():
    try:
        # Extracting features from the request
        features = {
            'battery_power': request.args.get('battery_power', type=float),
            'blue': request.args.get('blue', type=int),
            'clock_speed': request.args.get('clock_speed', type=float),
            'dual_sim': request.args.get('dual_sim', type=int),
            'fc': request.args.get('fc', type=int),
            'four_g': request.args.get('four_g', type=int),
            'int_memory': request.args.get('int_memory', type=int),
            'm_dep': request.args.get('m_dep', type=float),
            'mobile_wt': request.args.get('mobile_wt', type=int),
            'n_cores': request.args.get('n_cores', type=int),
            'pc': request.args.get('pc', type=int),
            'px_height': request.args.get('px_height', type=int),
            'px_width': request.args.get('px_width', type=int),
            'ram': request.args.get('ram', type=int),
            'sc_h': request.args.get('sc_h', type=int),
            'sc_w': request.args.get('sc_w', type=int),
            'talk_time': request.args.get('talk_time', type=int),
            'three_g': request.args.get('three_g', type=int),
            'touch_screen': request.args.get('touch_screen', type=int),
            'wifi': request.args.get('wifi', type=int)
        }

        features_df = pd.DataFrame([features])
        print(features_df)
        prediction = model.predict([features_df])[0]
        return jsonify(prediction=str(prediction))
    except Exception as e:
        return jsonify(error=str(e))

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
