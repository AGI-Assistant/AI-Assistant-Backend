import streamlit as st
import json
import os
from datetime import datetime as dt, time

# Config & initialisation
st.set_page_config(layout="wide", page_title="My Diary")
today = {"changelog": [],
         "activity": [],
         "rating": {},
         "comment": {},
         }

# Main title
st.title('Today is the {} welcome to your digital diary'
         .format(today["date"].strftime('%d.%m.%Y')))

# Split application into tabs
activities, rate, write, organize = st.tabs(
    ["What did you do today?", "Rate your day!", "Wanna mention something?", "Manage your diary's..."])

# Import tabs content/functionalities
with activities:
    # Specify how demanding the activity was.
    activity_category = st.selectbox('Tag based on cognitive demand',
                                     ['Concentration', 'Relaxation', 'Organizational'],
                                     index=2, key='activity_category')

    # Enter information about the activity
    activity_description = st.text_input(
        'Describe your activity', key='activity_description', value="", placeholder='What did you do?')
    activity_start = st.time_input(
        'Start time', key='activity_start', value=time(0, 0), disabled=False)
    activity_end = st.time_input(
        'End time', key='activity_end', value=time(0, 0), disabled=False)

    # Tag your activity
    activity_tags = st.multiselect("Activity was related to",
                                   options=['Academic', 'Business', 'Hobbies',
                                            'Breaks', 'Leisure', 'Exercise',
                                            'Housekeeping', 'Personal Care', 'Administrative'],
                                   key='activity_tags')

    # Spacing to make it look nicer
    st.markdown('<br/>', unsafe_allow_html=True)

    # Button to add a new activity
    if st.button("Add activity"):
        today["activity"].append(
            {"description": activity_description,
             "start": activity_start,
             "end": activity_end,
             "category": activity_category,
             "tags": activity_tags})

with rate:
    # Sliders and diagram
    col1, col2 = st.columns(2)

    # Sliders used to judge different activities
    with col1:
        # Subtitle and description
        st.header("How would you judge your...")

        # Sliders
        today["rating"]["focus"] = st.slider("ability to stay focused throughout the day.", 1, 5, 3)
        today["rating"]["starting_mood"] = st.slider("mood at the start of the day.", 1, 5, 3)
        today["rating"]["ending_mood"] = st.slider("mood at the end of the day.", 1, 5, 3)
        today["rating"]["satisfaction"] = st.slider("satisfaction with what you have achieved today.", 1, 5, 3)

    # Create the pie chart in the second column.
    with col2:
        # Subtitle and description
        st.header("Anything you wanna mention?")

        today["rating"]["focus_comment"] = st.text_input(
            "Did you feel stressed?", key='focus_comment')

        st.markdown('<br/>', unsafe_allow_html=True)
        today["rating"]["start_mood_comment"] = st.text_input(
            "What was responsible for this?", key='start_mood_comment')
        today["rating"]["end_mood_comment"] = st.text_input(
            "What should i write here?", key='end_mood_comment', label_visibility='hidden')

        st.markdown('<br/>', unsafe_allow_html=True)
        today["rating"]["satisfaction_comment"] = st.text_input(
            "What would others say?", key='satisfaction_comment')

    # Subtitle and description
    st.header("Tag your day using these!")

    # Checkboxes for tagging the day.
    today["rating"]["tags"] = st.multiselect(
        "Tag your day!", label_visibility='collapsed', help="Select all that apply",
        options=['productive', 'relaxed', 'stressful', 'fun',
                 'friends', 'colleagues', 'family', 'partner',
                 'happy', 'sad', 'exited', 'tired', 'depressed',
                 'junk-food', 'thc', 'insomnia', 'dispute',
                 'hot', 'cold', 'rainy'], key='tags')

with write:
    st.header("Is there anything else you wanna mention or comment on?")
    today['comment'] = st.text_area(label="Write here!", label_visibility='hidden',
                                    height=500, max_chars=1000, value="Heute habe ich")

with organize:
    # Save the day
    if st.button("Save the day!"):
        # Add a new entry to the changelog
        today["changelog"].append(f"Day saved on {dt.now().strftime('%d-%m-%Y %H:%M:%S')}")

        # Save the 'today' dictionary as a JSON file
        filename = f"diary_{dt.today().strftime('%d%m%Y')}.json"
        with open('./entries/' + filename, 'w') as f:
            json.dump(today, f)

        st.success(f"Day saved as {filename}!")

    # Select date for diary entry
    date_input = st.date_input(
        'If you want to change the date please do so, if not simply continue...',
        value=dt.strptime(today['date'], '%Y-%m-%d'))
    today['date'] = date_input.strftime('%Y-%m-%d')